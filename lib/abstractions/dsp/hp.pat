max v2;
#N vpatcher 10 59 255 387;
#P outlet 30 267 15 0;
#P window setfont "Sans Serif" 9.;
#P window linecount 1;
#P newex 142 91 55 196617 t b f;
#P newex 132 114 65 196617 * 1.412538;
#P newex 142 45 65 196617 r $1HPmute;
#B color 5;
#P newex 142 68 47 196617 * 1.416;
#P newex 30 237 35 196617 *~;
#P newex 113 191 51 196617 r galvol~;
#B color 5;
#P newex 50 264 63 196617 s $1HPout~;
#B color 5;
#P newex 88 212 35 196617 *~;
#P message 88 148 35 196617 \$1 30;
#P newex 88 170 42 196617 line~ 1.;
#P newex 132 22 63 196617 r $1HPtrim;
#B color 5;
#P newex 56 55 73 196617 r $1HPdelay~;
#B color 5;
#P newex 56 77 65 196617 mstosamps~;
#P newex 30 104 40 196617 delay~;
#P newex 50 31 57 196617 r $1HPin~;
#B color 5;
#P inlet 30 31 15 0;
#P newex 42 136 40 196617 sig~;
#P connect 1 0 3 0;
#P connect 2 0 3 0;
#P connect 3 0 12 0;
#P connect 12 0 17 0;
#P fasten 3 0 0 0 35 128 47 128;
#P connect 12 0 10 0;
#P fasten 9 0 12 1 93 233 60 233;
#P connect 5 0 4 0;
#P fasten 4 1 3 1 116 100 65 100;
#P fasten 15 0 8 0 137 139 93 139;
#P connect 8 0 7 0;
#P fasten 0 0 7 0 47 166 93 166;
#P connect 7 0 9 0;
#P connect 11 0 9 1;
#P connect 6 0 15 0;
#P fasten 16 0 15 0 147 111 137 111;
#P connect 14 0 13 0;
#P connect 13 0 16 0;
#P connect 16 1 15 1;
#P pop;
