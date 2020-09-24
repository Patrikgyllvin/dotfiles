#include <iostream>
#include <fstream>

#include <cstdlib>
#include <unistd.h>

void print_help()
{
	std::cout << "Usage:\n";
	std::cout << "kbd_brightness [-e | -d | -l<level> | -i<percentage> | -r<percentage>]\n";
	std::cout << "  where <level> is a number between 0 and 512.\n";
	std::cout << "  and new level must be between 0 and 512.\n";
}

int newLevelPercentage( float perc, std::string maxFile, std::string currFile )
{	
	int max, curr;
	
	std::ifstream in( maxFile, std::ios::in );
	in >> max;
	in.close();
	
	in.open( currFile, std::ios::in );
	in >> curr;
	
	int newLevel = curr + ( perc / 100.0f ) * max;
	if( std::abs( perc ) < 0 || newLevel > max || newLevel < 0 )
		return -1;
	else
		return newLevel;
}

int main( int argc, char *argv[] )
{
	const std::string currentFile = "/sys/class/leds/apple::kbd_backlight/brightness",
				maxFile = "/sys/class/leds/apple::kbd_backlight/max_brightness";
		
	bool eflag = false, dflag = false, lflag = false, iflag = false, rflag = false;
	
	int ch, level = -1;
	while( ( ch = getopt( argc, argv, "edhl:i:r:" ) ) != -1 )
	{
		switch( ch )
		{
		case 'e':
			eflag = true;

			if( dflag || lflag || iflag || rflag )
			{
				print_help();

				return EXIT_FAILURE;
			}

			level = 256;

			break;
		case 'd':
			dflag = true;
			
			if( eflag || lflag || iflag || rflag  )
			{
				print_help();
				
				return EXIT_FAILURE;
			}

			level = 0;

			break;
		case 'l':
			lflag = true;

			if( eflag || dflag || iflag || rflag  )
			{
				print_help();

				return EXIT_FAILURE;
			}

			level = atoi( optarg );

			if( level < 0 || level > 512 )
			{
				print_help();
				
				return EXIT_FAILURE;
			}
			
			break;
		case 'i':
			iflag = true;
			
			if( eflag || dflag || lflag || rflag  )
			{
				print_help();

				return EXIT_FAILURE;
			}
			
			level = newLevelPercentage( atof( optarg ), maxFile, currentFile );

			break;
		case 'r':
			rflag = true;
			
			if( eflag || dflag || lflag || iflag  )
			{
				print_help();

				return EXIT_FAILURE;
			}
			
			level = newLevelPercentage( -atof( optarg ), maxFile, currentFile );

			break;
		case '?':
		case 'h':
		default:
			print_help();
			
			return EXIT_FAILURE;
		}
	}

	if( level == -1 )
	{
		print_help();

		return EXIT_FAILURE;
	}

	std::ofstream out( currentFile, std::ios::trunc | std::ios::out );

	out << level;

	out.close();

	return 0;
}
