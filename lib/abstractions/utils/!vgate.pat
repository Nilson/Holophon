max v2;
#N vpatcher 15 55 286 252;
#P origin 0 -11;
#P window setfont "Sans Serif" 9.;
#P window linecount 1;
#P newex 31 71 50 196617 == 0;
#P inlet 199 12 15 0;
#P outlet 104 146 15 0;
#P inlet 150 12 15 0;
#P toggle 8 62 15 0;
#P newex 31 50 104 196617 r $1;
#B color 5;
#P newex 104 115 56 196617 gate 1 $2;
#P fasten 5 0 2 0 204 32 13 32;
#P connect 6 0 2 0;
#P connect 1 0 6 0;
#P fasten 2 0 0 0 13 107 109 107;
#P connect 0 0 4 0;
#P connect 3 0 0 1;
#P pop;
