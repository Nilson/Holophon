max v2;
#N vpatcher 41 42 817 665;
#N comlet params list;
#P inlet 370 47 15 0;
#N comlet presets;
#P inlet 303 32 15 0;
#P outlet 42 573 15 0;
#P newex 71 34 85 196617 r-sc $1InputGain;
#N comlet signal in;
#P inlet 42 22 15 0;
#P user umenu 303 83 21 196647 1 64 99;
#X add 1;
#X add 2;
#X add 3;
#X add 4;
#X add 5;
#X add 6;
#X add 7;
#X add 8;
#X add 9;
#X add 10;
#X add 11;
#X add 12;
#X add 13;
#X add 14;
#P flonum 71 58 35 9 0 0 0 3;
#N vpatcher 11 52 909 715;
#N comlet params list;
#P inlet 663 37 15 0;
#P inlet 82 21 15 0;
#P newex 218 56 110 196617 select 10 11 12 13 14;
#P newex 82 57 131 196617 select 1 2 3 4 5 6 7 8 9;
#P comment 79 200 14 196617 3;
#P comment 80 166 14 196617 2;
#P message 97 166 335 196617 0. 0.31 0.035176 0.522222 0.01005 0.511111 0.035176 0.767778 0.030151 0.855555 0.138 0.021 0.035 0.835555 0.450503;
#P message 96 199 299 196617 0. 0.49 0.035176 0.522222 0.01005 0.511111 0.035176 0.767778 0.015075 0.1 0.172 0.111 0.09 0.646667 0.359749;
#P message 445 116 311 196617 0. 0.36 0.135678 0.788889 0.160804 0.855555 0.160804 0.956667 0.170854 0.744444 0.178 0.207 0.0514 0.68 0.19598;
#P comment 429 122 14 196617 8;
#P comment 429 90 14 196617 7;
#P message 445 87 281 196617 0. 0.36 0.266332 0.5 0.170854 0.855555 0.160804 0.956667 0.070352 0.911111 0. 0. 0.0514 0.68 0.091457;
#P message 445 145 311 196617 0. 0.32 0.030151 0.5 0.085427 0.877777 0.115578 0.601111 0.015075 0.188889 0.6 0.099 0.01 0.157778 0.279548;
#P comment 430 145 14 196617 9;
#P comment 430 208 14 196617 11;
#P comment 430 177 14 196617 10;
#P comment 434 272 14 196617 13;
#P comment 434 303 14 196617 14;
#P comment 434 240 14 196617 12;
#P message 445 174 311 196617 0. 0.41 0.030151 0.5 0.085427 0.877777 0.115578 0.601111 0.015075 0.188889 0.6 0.099 0.01 0.157778 0.279548;
#P message 445 203 341 196617 0. 0.51 0.070352 0.644445 0.135678 0.944444 0.115578 0.856667 0.085427 0.066667 0.206 0.077 0.07055 0.913333 0.447236;
#P message 445 232 293 196617 0. 0.32 0.100503 0.644445 0.256281 0.944444 0.115578 0.856667 0.261307 0.744444 0. 0. 0.87 1. 0.447236;
#P message 445 290 323 196617 0. 0.39 0.175879 0.644445 0.351759 0.944444 0.005025 0.856667 0.251256 0.044445 0.128 0.5 0.055 0.211112 0.266332;
#P message 445 261 293 196617 0. 0.58 0.100503 0.644445 0.256281 0.944444 0.115578 0.856667 0.261307 0.455556 0.128 0.1 0.26 1. 0.266332;
#P comment 74 232 14 196617 4;
#P comment 74 295 14 196617 6;
#P message 96 293 285 196617 0. 0.18 0.266332 0.5 0.323668 0.877777 0.160804 0.956667 0.08794 0.255556 0.17 0.045 0.38 0.924444 0.1;
#P message 96 262 335 196617 0. 0.29 0.241206 0.522222 0.165829 0.511111 0.140704 0.767778 0.125628 0.577778 0.172 0.027 0.265 0.924444 0.279548;
#P newex 530 506 82 196617 s $1FilterCutoff;
#P newex 298 476 85 196617 s $1RV3Feedback;
#P newex 360 451 85 196617 s $1RV4Feedback;
#P newex 492 476 85 196617 s $1RV5Feedback;
#P newex 463 451 72 196617 s $1RV5Delay;
#P newex 423 506 90 196617 s $1RV4ModDepth;
#P newex 391 476 85 196617 s $1RV4ModFreq;
#P newex 314 506 72 196617 s $1RV4Delay;
#P newex 267 451 72 196617 s $1RV3Delay;
#P message 96 230 323 196617 0. 0.46 0.020101 0.811111 0.025126 0.877777 0.045226 0.956667 0.01005 0.255556 0.2 0.066 0.02 0.924444 0.470603 0.;
#P newex 223 506 85 196617 s $1RV2Feedback;
#P newex 174 451 85 196617 s $1RV1Feedback;
#P newex 206 476 72 196617 s $1RV2Delay;
#P newex 145 506 72 196617 s $1RV1Delay;
#P newex 112 476 80 196617 s $1ReverbGain;
#P newex 81 451 75 196617 s $1DirectGain;
#P newex 81 417 478 196617 unpack 1. 2. 3. 4. 5. 6. 7. 8. 9. 10. 11. 12. 13. 14. 15. 16.;
#P message 94 130 323 196617 0. 0.31 0.244221 0.311111 0.169095 0.233333 0.116482 0.767778 0.180905 0.855555 0.04 0.1 0.17 0.835555 0.450503 0.;
#P comment 78 131 14 196617 1;
#P comment 74 264 14 196617 5;
#P connect 46 0 44 0;
#P fasten 47 0 3 0 668 402 86 402;
#P connect 3 0 4 0;
#P connect 3 2 6 0;
#P connect 3 1 5 0;
#P connect 3 4 7 0;
#P fasten 3 5 9 0 241 470 228 470;
#P connect 3 3 8 0;
#P connect 3 6 11 0;
#P fasten 3 8 12 0 334 470 319 470;
#P connect 3 7 18 0;
#P connect 3 9 17 0;
#P connect 3 10 13 0;
#P fasten 3 12 15 0 458 442 468 442;
#P fasten 3 13 16 0 489 444 497 444;
#P fasten 3 11 14 0 427 470 428 470;
#P fasten 3 14 19 0 520 470 535 470;
#P fasten 45 1 27 0 243 81 450 81;
#P fasten 45 0 28 0 223 85 450 85;
#P fasten 45 2 26 0 263 82 450 82;
#P fasten 45 3 24 0 283 84 450 84;
#P fasten 45 4 25 0 303 86 450 86;
#P fasten 44 0 2 0 87 102 99 102;
#P fasten 44 2 40 0 113 113 101 113;
#P fasten 44 3 10 0 126 113 101 113;
#P fasten 44 4 20 0 139 112 101 112;
#P fasten 44 5 21 0 152 112 101 112;
#P fasten 44 1 41 0 100 120 102 120;
#P connect 44 9 45 0;
#P fasten 44 6 36 0 165 80 450 80;
#P fasten 44 7 39 0 178 84 450 84;
#P fasten 44 8 35 0 191 82 450 82;
#P fasten 41 0 3 0 102 368 86 368;
#P fasten 40 0 3 0 101 367 86 367;
#P fasten 36 0 3 0 450 382 86 382;
#P fasten 39 0 3 0 450 382 86 382;
#P fasten 28 0 3 0 450 380 86 380;
#P fasten 27 0 3 0 450 380 86 380;
#P fasten 26 0 3 0 450 381 86 381;
#P fasten 25 0 3 0 450 381 86 381;
#P fasten 24 0 3 0 450 380 86 380;
#P fasten 21 0 3 0 101 368 86 368;
#P fasten 20 0 3 0 101 366 86 366;
#P fasten 10 0 3 0 101 368 86 368;
#P fasten 2 0 3 0 99 366 86 366;
#P pop;
#P newobj 314 107 66 196620 p presets;
#P newex 113 70 91 196617 r-sc $1DirectGain;
#P newex 102 123 95 196617 r-sc $1ReverbGain;
#P newex 171 142 139 196617 r-sc $1RV1Delay 1. 200. ms;
#P newex 365 146 139 196617 r-sc $1RV2Delay 1. 200. ms;
#P newex 560 145 139 196617 r-sc $1RV3Delay 1. 200. ms;
#P newex 455 291 139 196617 r-sc $1RV4Delay 1. 200. ms;
#P newex 214 254 138 196617 r-sc $1RV4ModFreq 0. 5. Hz;
#P newex 305 279 135 196617 r-sc $1RV4ModDepth 0. 10.;
#P newex 226 368 139 196617 r-sc $1RV5Delay 0. 200. ms;
#P newex 291 389 132 196617 r-sc $1RV5Feedback 0. 0.9;
#P newex 519 312 132 196617 r-sc $1RV4Feedback 0. 0.9;
#P newex 231 161 132 196617 r-sc $1RV1Feedback 0. 0.9;
#P newex 423 170 132 196617 r-sc $1RV2Feedback 0. 0.9;
#P newex 626 169 132 196617 r-sc $1RV3Feedback 0. 0.9;
#P newex 149 490 171 196617 r-sc $1FilterCutoff 100. 20000. Hz;
#P flonum 113 93 55 9 0 0 0 3;
#P flonum 102 147 55 9 0 0 0 3;
#P flonum 171 165 55 9 0 0 0 3;
#P flonum 231 181 55 9 0 0 0 3;
#P flonum 365 171 55 9 0 0 0 3;
#P flonum 423 195 55 9 0 0 0 3;
#P flonum 560 170 61 9 0 0 0 3;
#P flonum 626 192 61 9 0 0 0 3;
#P flonum 455 313 61 9 0 0 0 3;
#P flonum 519 335 61 9 0 0 0 3;
#P flonum 214 275 61 9 0 0 0 3;
#P flonum 305 304 61 9 0 0 0 3;
#P flonum 226 392 61 9 0 0 0 3;
#P flonum 291 412 61 9 0 0 0 3;
#P flonum 149 517 61 9 0 0 0 3;
#P newex 140 298 38 196617 cycle~;
#P newex 140 329 27 196617 *~;
#P newex 140 352 40 196617 +~;
#P newex 99 374 92 196617 rev-unit~ 200. 0.3;
#P newex 99 461 98 196617 rev-unit~ 200. 0.3;
#P newex 85 253 94 196617 rev-unit~ 200. 0.3;
#P newex 85 226 94 196617 rev-unit~ 200. 0.3;
#P newex 85 170 27 196617 *~;
#P newex 99 545 60 196617 lowP1~;
#P newex 42 133 39 196617 *~ 0.5;
#P newex 42 84 39 196617 *~ 0.5;
#P newex 85 200 94 196617 rev-unit~ 200. 0.3;
#P connect 44 1 42 0;
#P connect 49 0 42 1;
#P connect 48 0 44 0;
#P connect 46 0 43 0;
#P connect 41 0 26 0;
#P connect 45 0 1 0;
#P connect 40 0 25 0;
#P connect 38 0 22 0;
#P connect 39 0 24 0;
#P connect 37 0 20 0;
#P connect 35 0 16 0;
#P connect 36 0 18 0;
#P connect 34 0 15 0;
#P connect 33 0 14 0;
#P connect 32 0 13 0;
#P connect 31 0 17 0;
#P connect 29 0 21 0;
#P connect 30 0 23 0;
#P connect 27 0 12 0;
#P connect 11 0 10 0;
#P connect 10 0 9 0;
#P connect 7 0 3 0;
#P fasten 6 0 8 0 90 333 104 333;
#P fasten 8 0 7 0 104 422 104 422;
#P connect 5 0 6 0;
#P connect 4 0 0 0;
#P connect 9 0 8 1;
#P connect 2 0 47 0;
#P fasten 1 0 4 0 47 114 90 114;
#P fasten 3 0 47 0 104 567 47 567;
#P connect 0 0 5 0;
#P connect 43 0 1 1;
#P connect 1 0 2 0;
#P fasten 26 0 2 1 118 119 76 119;
#P connect 25 0 4 1;
#P connect 28 0 19 0;
#P fasten 24 0 0 1 176 190 132 190;
#P fasten 22 0 5 1 370 219 132 219;
#P fasten 23 0 0 2 236 198 174 198;
#P fasten 20 0 6 1 565 245 132 245;
#P fasten 19 0 6 2 631 249 174 249;
#P fasten 21 0 5 2 428 222 174 222;
#P fasten 18 0 9 1 460 337 175 337;
#P fasten 16 0 11 0 219 293 145 293;
#P fasten 17 0 8 2 524 357 186 357;
#P fasten 15 0 10 1 310 323 162 323;
#P fasten 14 0 7 1 231 449 148 449;
#P fasten 13 0 7 2 296 456 192 456;
#P connect 12 0 3 1;
#P pop;
