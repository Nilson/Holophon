max v2;
#N vpatcher 92 143 345 468;
#P window setfont "Sans Serif" 9.;
#P window linecount 1;
#P newex 125 128 27 196617 -~;
#N comlet gain;
#P inlet 197 34 15 0;
#P newex 124 227 27 196617 +~;
#P newex 124 191 83 196617 *~ $2;
#P newex 38 65 27 196617 +~;
#N comlet dur;
#P inlet 130 32 15 0;
#P newex 38 215 73 196617 *~ $2;
#P newex 38 165 58 196617 tapout~ $1;
#P newex 38 114 55 196617 tapin~ 300;
#P outlet 124 269 15 0;
#N comlet signal;
#P inlet 38 33 15 0;
#P connect 0 0 6 0;
#P fasten 4 0 6 0 43 242 28 242 28 57 43 57;
#P connect 6 0 2 0;
#P connect 5 0 3 0;
#P connect 2 0 3 0;
#P connect 3 0 4 0;
#P connect 9 0 4 1;
#P connect 10 0 7 0;
#P connect 3 0 8 0;
#P connect 7 0 8 0;
#P connect 8 0 1 0;
#P connect 6 0 10 1;
#P connect 9 0 7 1;
#P pop;