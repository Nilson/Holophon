{
	"patcher" : 	{
		"fileversion" : 1,
		"rect" : [ 10.0, 59.0, 526.0, 504.0 ],
		"bglocked" : 0,
		"defrect" : [ 10.0, 59.0, 526.0, 504.0 ],
		"openrect" : [ 0.0, 0.0, 0.0, 0.0 ],
		"openinpresentation" : 0,
		"default_fontsize" : 12.0,
		"default_fontface" : 0,
		"default_fontname" : "Arial",
		"gridonopen" : 0,
		"gridsize" : [ 15.0, 15.0 ],
		"gridsnaponopen" : 0,
		"toolbarvisible" : 1,
		"boxanimatetime" : 200,
		"imprint" : 0,
		"enablehscroll" : 1,
		"enablevscroll" : 1,
		"boxes" : [ 			{
				"box" : 				{
					"bgcolor" : [ 1.0, 1.0, 1.0, 1.0 ],
					"bordercolor" : [ 0.5, 0.5, 0.5, 1.0 ],
					"id" : "obj-1",
					"knobcolor" : [ 0.2, 0.2, 0.2, 1.0 ],
					"maxclass" : "slider",
					"numinlets" : 1,
					"numoutlets" : 1,
					"orientation" : 2,
					"outlettype" : [ "" ],
					"patching_rect" : [ 173.0, 344.0, 17.0, 100.0 ]
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"id" : "obj-2",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 1,
					"outlettype" : [ "float" ],
					"patcher" : 					{
						"fileversion" : 1,
						"rect" : [ 20.0, 74.0, 128.0, 190.0 ],
						"bglocked" : 0,
						"defrect" : [ 20.0, 74.0, 128.0, 190.0 ],
						"openrect" : [ 0.0, 0.0, 0.0, 0.0 ],
						"openinpresentation" : 0,
						"default_fontsize" : 12.0,
						"default_fontface" : 0,
						"default_fontname" : "Arial",
						"gridonopen" : 0,
						"gridsize" : [ 15.0, 15.0 ],
						"gridsnaponopen" : 0,
						"toolbarvisible" : 1,
						"boxanimatetime" : 200,
						"imprint" : 0,
						"enablehscroll" : 1,
						"enablevscroll" : 1,
						"boxes" : [ 							{
								"box" : 								{
									"fontname" : "Arial",
									"fontsize" : 9.0,
									"id" : "obj-1",
									"maxclass" : "newobj",
									"numinlets" : 2,
									"numoutlets" : 1,
									"outlettype" : [ "float" ],
									"patching_rect" : [ 33.0, 71.0, 34.0, 17.0 ],
									"text" : "+ 0.5"
								}

							}
, 							{
								"box" : 								{
									"fontname" : "Arial",
									"fontsize" : 9.0,
									"id" : "obj-2",
									"maxclass" : "newobj",
									"numinlets" : 2,
									"numoutlets" : 1,
									"outlettype" : [ "float" ],
									"patching_rect" : [ 33.0, 51.0, 40.0, 17.0 ],
									"text" : "/ 360."
								}

							}
, 							{
								"box" : 								{
									"comment" : "",
									"id" : "obj-3",
									"maxclass" : "outlet",
									"numinlets" : 1,
									"numoutlets" : 0,
									"patching_rect" : [ 33.0, 112.0, 15.0, 15.0 ]
								}

							}
, 							{
								"box" : 								{
									"comment" : "",
									"id" : "obj-4",
									"maxclass" : "inlet",
									"numinlets" : 0,
									"numoutlets" : 1,
									"outlettype" : [ "float" ],
									"patching_rect" : [ 33.0, 28.0, 15.0, 15.0 ]
								}

							}
 ],
						"lines" : [ 							{
								"patchline" : 								{
									"destination" : [ "obj-3", 0 ],
									"hidden" : 0,
									"midpoints" : [  ],
									"source" : [ "obj-1", 0 ]
								}

							}
, 							{
								"patchline" : 								{
									"destination" : [ "obj-1", 0 ],
									"hidden" : 0,
									"midpoints" : [  ],
									"source" : [ "obj-2", 0 ]
								}

							}
, 							{
								"patchline" : 								{
									"destination" : [ "obj-2", 0 ],
									"hidden" : 0,
									"midpoints" : [  ],
									"source" : [ "obj-4", 0 ]
								}

							}
 ]
					}
,
					"patching_rect" : [ 71.0, 346.0, 55.0, 17.0 ],
					"saved_object_attributes" : 					{
						"default_fontsize" : 12.0,
						"fontname" : "Arial",
						"default_fontface" : 0,
						"globalpatchername" : "",
						"default_fontname" : "Arial",
						"fontface" : 0,
						"fontsize" : 12.0
					}
,
					"text" : "p dial2deg"
				}

			}
, 			{
				"box" : 				{
					"bgcolor" : [ 1.0, 1.0, 1.0, 1.0 ],
					"bordercolor" : [ 0.5, 0.5, 0.5, 1.0 ],
					"id" : "obj-3",
					"knobcolor" : [ 0.2, 0.2, 0.2, 1.0 ],
					"maxclass" : "slider",
					"numinlets" : 1,
					"numoutlets" : 1,
					"orientation" : 2,
					"outlettype" : [ "" ],
					"patching_rect" : [ 135.0, 350.0, 31.0, 90.0 ]
				}

			}
, 			{
				"box" : 				{
					"filename" : "jsui_360dial.js",
					"id" : "obj-4",
					"jsarguments" : [  ],
					"maxclass" : "jsui",
					"numinlets" : 1,
					"numoutlets" : 1,
					"outlettype" : [ "" ],
					"patching_rect" : [ 71.0, 372.0, 57.0, 57.0 ]
				}

			}
, 			{
				"box" : 				{
					"bgcolor" : [ 1.0, 1.0, 1.0, 1.0 ],
					"bordercolor" : [ 0.5, 0.5, 0.5, 1.0 ],
					"id" : "obj-5",
					"knobcolor" : [ 0.2, 0.2, 0.2, 1.0 ],
					"maxclass" : "slider",
					"numinlets" : 1,
					"numoutlets" : 1,
					"orientation" : 2,
					"outlettype" : [ "" ],
					"patching_rect" : [ 173.0, 107.0, 17.0, 100.0 ]
				}

			}
, 			{
				"box" : 				{
					"bkgndpict" : "SliderDefaultBkgnd.pct",
					"bottommargin" : 4,
					"bottomvalue" : -100,
					"id" : "obj-6",
					"imagemask" : 1,
					"knobpict" : "SliderDefaultKnob.pct",
					"leftmargin" : 4,
					"leftvalue" : -100,
					"maxclass" : "pictslider",
					"numinlets" : 2,
					"numoutlets" : 2,
					"outlettype" : [ "int", "int" ],
					"patching_rect" : [ 71.0, 107.0, 100.0, 100.0 ],
					"rightmargin" : 4,
					"rightvalue" : 100,
					"topmargin" : 4,
					"topvalue" : 100
				}

			}
, 			{
				"box" : 				{
					"bgcolor" : [ 0.866667, 0.866667, 0.866667, 1.0 ],
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"htextcolor" : [ 0.870588, 0.870588, 0.870588, 1.0 ],
					"id" : "obj-7",
					"maxclass" : "flonum",
					"numinlets" : 1,
					"numoutlets" : 2,
					"outlettype" : [ "float", "bang" ],
					"patching_rect" : [ 173.0, 323.0, 35.0, 17.0 ],
					"textcolor" : [ 0.0, 0.0, 0.0, 1.0 ],
					"triscale" : 0.9
				}

			}
, 			{
				"box" : 				{
					"bgcolor" : [ 0.866667, 0.866667, 0.866667, 1.0 ],
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"htextcolor" : [ 0.870588, 0.870588, 0.870588, 1.0 ],
					"id" : "obj-8",
					"maxclass" : "flonum",
					"numinlets" : 1,
					"numoutlets" : 2,
					"outlettype" : [ "float", "bang" ],
					"patching_rect" : [ 122.0, 323.0, 35.0, 17.0 ],
					"textcolor" : [ 0.0, 0.0, 0.0, 1.0 ],
					"triscale" : 0.9
				}

			}
, 			{
				"box" : 				{
					"bgcolor" : [ 0.866667, 0.866667, 0.866667, 1.0 ],
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"htextcolor" : [ 0.870588, 0.870588, 0.870588, 1.0 ],
					"id" : "obj-9",
					"maxclass" : "flonum",
					"numinlets" : 1,
					"numoutlets" : 2,
					"outlettype" : [ "float", "bang" ],
					"patching_rect" : [ 71.0, 323.0, 35.0, 17.0 ],
					"textcolor" : [ 0.0, 0.0, 0.0, 1.0 ],
					"triscale" : 0.9
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"id" : "obj-10",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 3,
					"outlettype" : [ "float", "float", "float" ],
					"patching_rect" : [ 71.0, 301.0, 112.0, 17.0 ],
					"text" : "unpack 0. 0. 0."
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 0.658824, 0.658824, 0.658824, 1.0 ],
					"id" : "obj-11",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 208.0, 323.0, 16.0, 17.0 ],
					"text" : "z"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 0.658824, 0.658824, 0.658824, 1.0 ],
					"id" : "obj-12",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 157.0, 323.0, 16.0, 17.0 ],
					"text" : "d"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 0.658824, 0.658824, 0.658824, 1.0 ],
					"id" : "obj-13",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 106.0, 323.0, 16.0, 17.0 ],
					"text" : "a"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"id" : "obj-14",
					"maxclass" : "newobj",
					"numinlets" : 3,
					"numoutlets" : 1,
					"outlettype" : [ "" ],
					"patching_rect" : [ 71.0, 238.0, 112.0, 17.0 ],
					"text" : "pack 0. 0. 0."
				}

			}
, 			{
				"box" : 				{
					"bgcolor" : [ 0.866667, 0.866667, 0.866667, 1.0 ],
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"htextcolor" : [ 0.870588, 0.870588, 0.870588, 1.0 ],
					"id" : "obj-15",
					"maxclass" : "flonum",
					"numinlets" : 1,
					"numoutlets" : 2,
					"outlettype" : [ "float", "bang" ],
					"patching_rect" : [ 173.0, 213.0, 35.0, 17.0 ],
					"textcolor" : [ 0.0, 0.0, 0.0, 1.0 ],
					"triscale" : 0.9
				}

			}
, 			{
				"box" : 				{
					"bgcolor" : [ 0.866667, 0.866667, 0.866667, 1.0 ],
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"htextcolor" : [ 0.870588, 0.870588, 0.870588, 1.0 ],
					"id" : "obj-16",
					"maxclass" : "flonum",
					"numinlets" : 1,
					"numoutlets" : 2,
					"outlettype" : [ "float", "bang" ],
					"patching_rect" : [ 122.0, 213.0, 35.0, 17.0 ],
					"textcolor" : [ 0.0, 0.0, 0.0, 1.0 ],
					"triscale" : 0.9
				}

			}
, 			{
				"box" : 				{
					"bgcolor" : [ 0.866667, 0.866667, 0.866667, 1.0 ],
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"htextcolor" : [ 0.870588, 0.870588, 0.870588, 1.0 ],
					"id" : "obj-17",
					"maxclass" : "flonum",
					"numinlets" : 1,
					"numoutlets" : 2,
					"outlettype" : [ "float", "bang" ],
					"patching_rect" : [ 71.0, 213.0, 35.0, 17.0 ],
					"textcolor" : [ 0.0, 0.0, 0.0, 1.0 ],
					"triscale" : 0.9
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 0.658824, 0.658824, 0.658824, 1.0 ],
					"id" : "obj-18",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 208.0, 213.0, 16.0, 17.0 ],
					"text" : "z"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 0.658824, 0.658824, 0.658824, 1.0 ],
					"id" : "obj-19",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 157.0, 213.0, 16.0, 17.0 ],
					"text" : "y"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 0.658824, 0.658824, 0.658824, 1.0 ],
					"id" : "obj-20",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 106.0, 213.0, 16.0, 17.0 ],
					"text" : "x"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"id" : "obj-21",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 1,
					"outlettype" : [ "" ],
					"patching_rect" : [ 71.0, 270.0, 65.0, 17.0 ],
					"text" : "holo.car2pol"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"hidden" : 1,
					"id" : "obj-22",
					"maxclass" : "message",
					"numinlets" : 2,
					"numoutlets" : 1,
					"outlettype" : [ "" ],
					"patching_rect" : [ 417.0, 70.0, 75.0, 15.0 ],
					"text" : "brgb 40 36 37"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 1.0, 1.0, 1.0, 1.0 ],
					"id" : "obj-23",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 392.0, 50.0, 82.0, 17.0 ],
					"text" : "28-04-2005",
					"textcolor" : [ 1.0, 1.0, 1.0, 1.0 ]
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 1.0, 1.0, 1.0, 1.0 ],
					"id" : "obj-24",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 265.0, 35.0, 168.0, 17.0 ],
					"text" : "All rights reserved",
					"textcolor" : [ 1.0, 1.0, 1.0, 1.0 ]
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 1.0, 1.0, 1.0, 1.0 ],
					"id" : "obj-25",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 265.0, 20.0, 168.0, 17.0 ],
					"text" : "© 2004-2007 Gmem",
					"textcolor" : [ 1.0, 1.0, 1.0, 1.0 ]
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 1.0, 1.0, 1.0, 1.0 ],
					"id" : "obj-26",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 265.0, 50.0, 168.0, 17.0 ],
					"text" : "contact : dvlpt@gmem.fr",
					"textcolor" : [ 1.0, 1.0, 1.0, 1.0 ]
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 1.0, 1.0, 1.0, 1.0 ],
					"id" : "obj-27",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 19.0, 49.0, 266.0, 17.0 ],
					"text" : "cartesian 2 polar coordinates converter",
					"textcolor" : [ 1.0, 1.0, 1.0, 1.0 ]
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 12.0,
					"frgb" : [ 0.968627, 0.968627, 0.968627, 1.0 ],
					"id" : "obj-28",
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 19.0, 19.0, 157.0, 20.0 ],
					"text" : "holo.car2pol",
					"textcolor" : [ 0.968627, 0.968627, 0.968627, 1.0 ]
				}

			}
, 			{
				"box" : 				{
					"data" : [ 3617, "png", "IBkSG0fBZn....PCIgDQRA...PF...fFHX....PPJme4....DLmPIQEBHf.B7g.YHB..MfcRDEDUnEX6ZtGcUUkeG+ydedbO49H4xaRfnADnEvVIfOAl03pcIHXaUQqJZUbUqnV0N1YsFbPqN5zwY5nFeqPBDn0gp1+vJRQGW0AFdrfAIJAGQfDdHn7J4RdcSx804wt+w4duP3lDzwRr+Q+tVm0MYe1+1me+1+16eu1awEW4TU7+iuygmqKQiFE8NZu89rSBgnf1Tpud5u7zpTn5s1+ZNlea3gdc7Nyw5aBsmCkIWWWDBA5ZZZEzYWWWrsswwwAkmGf.DflThtgA555Hkxd8iJDBrcbHcxjn.BDH.FFF353fsiC1118foEBAFYGScc87s444gssM111m56n7YEMMs7zHDh9W3yRlq.bDJbA7Df.An.cDnoTnqNUe6MYxwwgjISB.lllDHP.bxJON43Qg.x9qttNFFFnookWA355hiiCN113kkmUJk+hDg.kmG5m9G0yyi3w6DSSCtfwcALoIegL5xGMAKJHszRKbf8ue97csKNwINAlllTTQEUvjgssMkUVYLwIOYjBAM1PC7Ye1mQQVVLtwOdtnoLEpnhJvvzjN5nCN9wOFMr2FX+6aeDOdbBFLHISlDgPv4e9mOSoxJYLicrDLTPRjHAwZNFewAN.6YO6gVN4IonfAwvvn2Wb.jQ.oDPXOXboELFaHhm+DTbIbHC3KM8+6.JvRUnRwwwgQNxQxjl7jQJk7EG7fTe80ikkEWv3FGWzTtHpnhJvzL.wiGmicziRiMz.6ae6iN6ry7xjTJo7xKmoTYkL1K3BHTnPjHYBZ9DMSiM1.wZt4SoPbccoyt5hK6xtTt8Er.tpYMKhDIROXLEvA1+AXMqd07uupUQSm3DEzmt5pKl9LmA+he4uD.d9ppBDBtm669XVyZVTRzRJXhKYxjr0srUpslZX8qacLkoMMl+sNelybmCCe3inf9qTJ16d1KuwpVEu0a8VjISFLMM6gRQ.jTnvPI35iK3uHtfIlRPwJPK6TtKBhKfFsT7AQT7AEqnSIDxqmJkt6tat7q3x4oqpJ.Xk0tBbbcXg268xUMqYSz9Rl15VYkKuVV2G9g7mNkovsda2FW8bmCiXDEJSNNNbf8e.DSb7SPYaaisiMK7dtWt+G39ojnQKffyD6ZWeNO9i9nT212NgCGNe6czdG72rf6fm9YeF.3KN3AIRwEyPG5POqiYrXwXSabiL8YLCJszROq8GfkWSM7y+YOE555b5leSHgxy.ObyRtxDBj.1.R.QNae.d3a1BT7wVJdlg4wNKxeGUNK8wiGmaY9ympdgmG.NxQNBABDfgMrgcV4uVNYKr4MuYtjK8RXTiZTm09KF+XFqJcpTrnEuXt+G7Ax+hFanAd228cYW+9cQhDcyHFwH36ekWIydNWMEWbw4Yz68tWHacKaghJpHfBUH4PSM0DaZiaj52wNHVywP44QICJJSZxSlqdNWMiZTitG8OYxj7I0UGadSalCe3CSFaaJNRDl3DmHydtygJpnB+ITOO9aWvcx5W25HTnP.BRHUbdYfpNljKJifjYm9+Jc3SKRwWYnPghQ4HYxIgQ3HvToHLBNgN7XC2ksFx27UuoPxgXMGiMtgMP80WOwZpIb87HZznLwIMQly0bMEn.RmJM0UWcr4MrAN7W9kX63PjvgY7SXBL2q4ZXLicLn2Ymcxcbm2I228+2C.oRkhZptZV5qsDZskVHPf.4cp8e91uMUN0oxi8Sdbt7q3J3HG4njISldMpgbn6t6lU85uNqbEqju5K+RDBARoDAfmRQlLYXEKa47JKYIT4TqD.1yt2MO5heT93Od63X6fttukUkRgssM0Tc07huxKyL+deOjRI+4y5p32t90C363tHO3GGSxeRFIIPQBIrxA4w6Thhl0gbQGjQ5wHsgm+nRpLkftAJyAlPFAaIT1fY5EjLQBV0uZUrxZqkCenCARI5ZZnTJTdd333vJqcE7Ru1qxzl1z.fF16d4e5QdDpa60QlLYxGPhmmGoyjgkUyx3Ee4WD8wOgIvC7fOHRoDWGG9YO4OkkUc0DNRDFxPFBddd.mJTscVe87PO3+.W8bmKqcMqglZpIhDIReFoya9FuAKdQOLQJtXJojBs0B96FWwxqkW90dE.n9crC1v5WGCa3CGsPEFE3wN1w3EdtmmYLyYhPH37Ju77lqRIfapCAe+tEzEJRKE73izk2OhhfJHhG.BrEftGrf1DLozfBElHnpg3wJGrh.d88hr+q0rFV7hdXBENTeZdee6aerrpqgoUS0Ykocxu4+9CYjibjDLTH+nwxhhEBh0bS7u7T+bzuoa9lo7yq7rSduIKeYKiRhFEcc8SoLf7g0EMZThEKFKu5pwxxp.m5mIZu01wvzjPgB0mJs.VVzbymfToRgkkEgBGlHEWbuFRqRoHXvfzZqsRhDIxalRo78GDzCt13Bb.LAdsA6x6EwiA456GA7i7xC3G0rj6ncANYcg+RCwiZFhh.JPi9NGk3w6DcC89Ulrrr3jwhQpjIwpnhHTnfTbwE6OlYmWOcYJb3vzTyMi97tga..5LdbVQs0hkkUOxGvOW.GD9ZkrCgeb1ttdjLQBT.Roj.ABTvtbCSCz5ibVNcb5wqqTp7O8k4vblw.+U2BfzRXxoDL1LBDn3PFBVSDEg7D4Yqj9oTwhhI31ZWfMJDH3EFpG0NXeyc53qv7DfrWXaCC+.H7775S9SoTnqo6maR1+2qelC76uF5kMpx.fs+QamCenCgkkU9IOOOOBGNBACELaBh89.JkZjISFh2Ymeqxh9aKrAFSZ+vVMPvmVjhV0AS0odeXO3GbRI2RG9JCkPvyMDEqbvJBmMb23Z9Jhh75KuHm6P9kYewAOH111XXX.3qw5tqt41WvcvBum6gzoS22aOKJHebc0wO5G9Cw4zxDefDprOCwg7llNpA3H7S3CfLR3OKtfauCA9bofpFpG+qCRQHke17Q7f40pjKNAzpF7RCyC6APsxoRLzyqGNZ.v00gRKqLF1vG9YcfJszQ1mkSYf.4lybkmpMo5TsK.r7fMDQwRR4wcztjpFlh+srJCcEzsDFrCb+sJXztv1BnP1KYtetD4UHit7xQOaIHxYWzvzjc86+L17l1LYxjoGJLaaaF5vFJUN0ohllFszRKjJcJDRYgekAHHAho4aZx.EUjwuFUdBPnHexgKanJ1XXW1kku4sbbrqHaV5JEowubJ1hAVyV5s0VaLnAMHtrK6xnzRKkie7imO2ifACx6s10x6s10l0IqOQBAzRKsvO3e7g3hujKA.ZrgFIQWcyYVrxARXnfCD.5VpP2SvTRBizVwwMAsr7toBb.9jf9QjkaxVA3BLoTBJwy2o9QMTzsT0qN1OWA46u12C.F5vFJy+VuU5tqtJH5FWWWTddnTdHDPGczAiZzila7u9l.7qe0l2zlxGs02EPguuhuvPwts7W0WpqfapCAIkprU30ueR72Ib5lyRHgA6pXNcJPGHMB1QQ96PFHWhIeq27MIdGwAf+t6YgbsyadzRKsfiiS9rpMLLvvzDSSSRkJEgBElm7I+oLoIOI.32sksxGsssQvfAG.Y8Bg.vVp3sKw+7JRih42lfarcIcn4GVrfBeRH8KK+c2hFWTJANHX+lvVBqvRMvZxRtiO4Sn1kub.+jYd5m8Y3tW3BIS5Lzd6sSpToHc5zzc2cSas0FkMpQwK9JuLW+MNO.3jm7j7bUUEN4hP663yezRIX8gU79gUDAAFH3wZRxC0rfPtPGRnKouC7NkJ5PBivVvSbBIKnMA1HvCXkC1iXZfkmXf0odQVVrjW8UYLicrbcW+0QznQ4e9W7T7Wds+Ur52Y0z3d2KISkhAO3AyLl4L45ug4QYk4m6R5zo4Ie7mfOcm6jnQi9cZNH4flxOS7mc3dLBGIyHkfjJ3daUxr6B1RPE6MfhDZJh3J4BSIXFcKXzN9qkLPwxGjGqsX+DJUhAVYR2LP.RmNMKdQKhN6LN27sbKXZZxUL8oyUL8oiqqKtttXZZ1CBat4l4I+IOAq9cdG+RB7+ATF4PQJ3jZJVTodrnXRlcWBL.FaFXbYD9mZHx7gXp.B.zt.Vwf7XYCQggJWY5GXgtRoHPf.jISFdze7hYqaYqbW20cwEeo9QOooo0iHmh2QG7q+0e.Kq5kxt+7cSwYq4TNnvuD.4fgwopTa+UlAoTKe.AlFl8Z+5Q+EBLylDauEYWHkfV0gGoTO1PmBtt3BtvjPDkHqhvuhud.wEvuInh+inJ1VHOBnDXbF4eb5kpQW2ne4ubPpIyOWnaXzuUEO+XmS.MMMQJkrlUuZ1zF1.UVYkL0oMMNuJp.KKKZqsVYO6d2T2GUGM1XC9mmQIkTPA.srrXO6d2T8RqFMMIa62sMBXY0uLSf.A3nG4HT8RqlfAKhcti5wzzruqiklFwi2Iq50+UDt3Hr6O+yQWumJEE9mmgs.d2hU7aCqXrYf+nzBJ01Oj2tzTbDCXuATbPSeScA8DETXQq.AXu6YOTyRqFMMM9nsss7oFzWvzzjicriwRWxRIXvf7o6bmX70PoH9iG236w9REfqiCYxjI+Mg.J7BIzW4ajqfjoRlBE969BDHvY8VXj6RDn77vnONu9SGdddjHQB+KFfgAACFre6uKfizOGjbmWXte0U9qL05CxyISISlDTfY.e9y6LpZaeKSJLLM5WYxM60.p.ExYNnmI9FeMfNGQSO3sy3Z4zuz0Ks80l1ukxT+QWNEhdu91ugez+2h1uIz7GJu8swM84ZYRHD7+.s.sdp8dCcjD.....IUjSD4pPfIH" ],
					"embed" : 1,
					"id" : "obj-29",
					"maxclass" : "fpic",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 388.0, 20.0, 100.0, 26.0 ]
				}

			}
, 			{
				"box" : 				{
					"bgcolor" : [ 0.156863, 0.141176, 0.145098, 1.0 ],
					"border" : 1,
					"id" : "obj-30",
					"maxclass" : "panel",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 12.0, 13.0, 481.0, 54.0 ],
					"rounded" : 0,
					"shadow" : 2
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Arial",
					"fontsize" : 9.0,
					"frgb" : [ 0.658824, 0.658824, 0.658824, 1.0 ],
					"id" : "obj-31",
					"linecount" : 2,
					"maxclass" : "comment",
					"numinlets" : 1,
					"numoutlets" : 0,
					"patching_rect" : [ 20.0, 72.0, 246.0, 27.0 ],
					"text" : "polar coordinates with angle in degree starting in front at 0° and increasing clockwise > 360°"
				}

			}
 ],
		"lines" : [ 			{
				"patchline" : 				{
					"destination" : [ "obj-7", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-10", 2 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-8", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-10", 1 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-9", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-10", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-21", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-14", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-14", 2 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-15", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-14", 1 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-16", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-14", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-17", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-4", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-2", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-10", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-21", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-30", 0 ],
					"hidden" : 1,
					"midpoints" : [  ],
					"source" : [ "obj-22", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-15", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-5", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-16", 0 ],
					"hidden" : 0,
					"midpoints" : [ 161.5, 210.0, 131.5, 210.0 ],
					"source" : [ "obj-6", 1 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-17", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-6", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-1", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-7", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-3", 0 ],
					"hidden" : 0,
					"midpoints" : [ 131.5, 344.0, 144.5, 344.0 ],
					"source" : [ "obj-8", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-2", 0 ],
					"hidden" : 0,
					"midpoints" : [  ],
					"source" : [ "obj-9", 0 ]
				}

			}
 ]
	}

}
