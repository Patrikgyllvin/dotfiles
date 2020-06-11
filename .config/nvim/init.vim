call plug#begin(stdpath('data') . '/plugged')

Plug 'neoclide/coc.nvim', {'branch': 'release'}

"Plug 'jackguo380/vim-lsp-cxx-highlight'

Plug 'rakr/vim-one'

Plug 'vifm/vifm.vim'

Plug 'mhinz/vim-startify'

Plug 'tpope/vim-fugitive'

call plug#end()

set runtimepath^=~/.vim runtimepath+=~/.vim/after
let &packpath = &runtimepath

inoremap jk <Esc>

nnoremap <SPACE> <Nop>
let mapleader=" "

nnoremap <leader>d "_d
xnoremap <leader>d "_d
xnoremap <leader>p "_dP

nmap <space>e :CocCommand explorer<CR>

set number relativenumber

set tabstop=4
set softtabstop=0 noexpandtab
set shiftwidth=4
set autoindent
set smartindent
set cindent
set shiftround

" Highlight matches when searching
set hlsearch

" Better autocompletion
set wildmenu
set wildmode=full
set wildignore=".git/*,.clangd/*,build/*"
set completeopt=menuone,noinsert

" Automatically write file on buffer closing
set autowrite

" Don't wrap line
set nowrap

set lazyredraw

set ignorecase smartcase

" Better scrolling, N more rows/columns when scrolling up/down or left/right
set scrolloff=10
set sidescrolloff=5

filetype on
filetype plugin on
filetype indent on

packadd! onedark.vim

"Use 24-bit (true-color) mode in Vim/Neovim when outside tmux.
"If you're using tmux version 2.2 or later, you can remove the outermost $TMUX check and use tmux's 24-bit color support
"(see < http://sunaku.github.io/tmux-24bit-color.html#usage > for more information.)
if (empty($TMUX))
  if (has("nvim"))
    "For Neovim 0.1.3 and 0.1.4 < https://github.com/neovim/neovim/pull/2198 >
    let $NVIM_TUI_ENABLE_TRUE_COLOR=1
  endif
  "For Neovim > 0.1.5 and Vim > patch 7.4.1799 < https://github.com/vim/vim/commit/61be73bb0f965a895bfb064ea3e55476ac175162 >
  "Based on Vim patch 7.4.1770 (`guicolors` option) < https://github.com/vim/vim/commit/8a633e3427b47286869aa4b96f2bfc1fe65b25cd >
  " < https://github.com/neovim/neovim/wiki/Following-HEAD#20160511 >
  if (has("termguicolors"))
    set termguicolors
  endif
endif

"--- C++ enhanced syntax highlighting ---
let g:cpp_class_decl_highlight = 1
let g:cpp_class_scope_highlight = 1
let g:cpp_concepts_highlight = 1
let g:cpp_posix_standard = 1
let g:cpp_member_variable_highlight = 1
let g:cpp_experimental_simple_template_highlight = 1

let g:one_allow_italics = 1
" let g:onedark_hide_endofbuffer=1

" let java_highlight_functions = 1

syntax on
colorscheme one
set background=dark
