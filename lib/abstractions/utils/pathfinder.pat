max v2;
#N vpatcher 20 74 251 202;
#P window setfont "Sans Serif" 9.;
#P window linecount 1;
#P newex 106 65 62 196617 s i-exist;
#B color 5;
#P message 106 38 21 196617 $1;
#P newex 106 15 59 196617 r exists;
#B color 5;
#P newex 18 17 62 196617 r $1path;
#B color 5;
#P newex 18 63 77 196617 filepath search;
#P newex 18 40 62 196617 prepend set;
#P connect 2 0 0 0;
#P connect 0 0 1 0;
#P connect 3 0 4 0;
#P connect 4 0 5 0;
#P pop;
