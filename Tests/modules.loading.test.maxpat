{
	"patcher" : 	{
		"fileversion" : 1,
		"appversion" : 		{
			"major" : 6,
			"minor" : 0,
			"revision" : 8
		}
,
		"rect" : [ 396.0, 73.0, 871.0, 425.0 ],
		"bglocked" : 0,
		"openinpresentation" : 0,
		"default_fontsize" : 10.0,
		"default_fontface" : 0,
		"default_fontname" : "Verdana",
		"gridonopen" : 0,
		"gridsize" : [ 5.0, 5.0 ],
		"gridsnaponopen" : 0,
		"statusbarvisible" : 2,
		"toolbarvisible" : 1,
		"boxanimatetime" : 200,
		"imprint" : 0,
		"enablehscroll" : 1,
		"enablevscroll" : 1,
		"devicewidth" : 0.0,
		"description" : "",
		"digest" : "",
		"tags" : "",
		"boxes" : [ 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-4",
					"maxclass" : "newobj",
					"numinlets" : 2,
					"numoutlets" : 3,
					"outlettype" : [ "", "", "" ],
					"patching_rect" : [ 554.0, 61.0, 108.0, 19.0 ],
					"text" : "jmod.holoTransport"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-3",
					"maxclass" : "newobj",
					"numinlets" : 2,
					"numoutlets" : 2,
					"outlettype" : [ "", "audio.connect" ],
					"patching_rect" : [ 554.0, 36.0, 123.0, 19.0 ],
					"text" : "jmod.holoSoundcues~"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-21",
					"maxclass" : "newobj",
					"numinlets" : 3,
					"numoutlets" : 1,
					"outlettype" : [ "int" ],
					"patching_rect" : [ 195.0, 298.0, 53.0, 19.0 ],
					"text" : "accum 0"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-13",
					"maxclass" : "newobj",
					"numinlets" : 2,
					"numoutlets" : 2,
					"outlettype" : [ "", "" ],
					"patching_rect" : [ 373.0, 238.0, 65.0, 19.0 ],
					"text" : "route error"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-11",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 1,
					"outlettype" : [ "" ],
					"patching_rect" : [ 373.0, 213.0, 45.0, 19.0 ],
					"text" : "error 1"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-2",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 1,
					"outlettype" : [ "" ],
					"patching_rect" : [ 554.0, 8.0, 113.0, 19.0 ],
					"text" : "jmod.holoReccontrol"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-14",
					"maxclass" : "newobj",
					"numinlets" : 2,
					"numoutlets" : 1,
					"outlettype" : [ "" ],
					"patching_rect" : [ 195.0, 325.0, 378.0, 19.0 ],
					"text" : "jcom.test.assert.equal.old \"TEST Holophon AllModulesLoadingProperly\" 0"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-1",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 2,
					"outlettype" : [ "bang", "bang" ],
					"patching_rect" : [ 50.0, 110.0, 34.0, 19.0 ],
					"text" : "t b b"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-6",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 3,
					"outlettype" : [ "", "bang", "bang" ],
					"patching_rect" : [ 50.0, 85.0, 83.0, 19.0 ],
					"text" : "jcom.test.start"
				}

			}
, 			{
				"box" : 				{
					"id" : "obj-7",
					"maxclass" : "button",
					"numinlets" : 1,
					"numoutlets" : 1,
					"outlettype" : [ "bang" ],
					"patching_rect" : [ 50.0, 60.0, 20.0, 20.0 ]
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-10",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 2,
					"outlettype" : [ "", "" ],
					"patching_rect" : [ 50.0, 225.0, 67.0, 19.0 ],
					"save" : [ "#N", "thispatcher", ";", "#Q", "end", ";" ],
					"text" : "thispatcher"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-12",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 1,
					"outlettype" : [ "" ],
					"patching_rect" : [ 50.0, 200.0, 100.0, 19.0 ],
					"text" : "jcom.test.finished"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-52",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 3,
					"outlettype" : [ "bang", "bang", "int" ],
					"patching_rect" : [ 195.0, 170.0, 46.0, 19.0 ],
					"text" : "t b b 0"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-53",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 1,
					"outlettype" : [ "int" ],
					"patching_rect" : [ 288.0, 263.0, 24.0, 19.0 ],
					"text" : "t 1"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-54",
					"maxclass" : "newobj",
					"numinlets" : 2,
					"numoutlets" : 2,
					"outlettype" : [ "", "" ],
					"patching_rect" : [ 288.0, 238.0, 74.0, 19.0 ],
					"text" : "route jbogus"
				}

			}
, 			{
				"box" : 				{
					"fontname" : "Verdana",
					"fontsize" : 10.0,
					"id" : "obj-56",
					"maxclass" : "newobj",
					"numinlets" : 1,
					"numoutlets" : 5,
					"outlettype" : [ "", "", "", "", "" ],
					"patching_rect" : [ 245.0, 213.0, 104.0, 19.0 ],
					"saved_object_attributes" : 					{
						"filename" : "patchdescribe.js",
						"parameter_enable" : 0
					}
,
					"text" : "js patchdescribe.js"
				}

			}
 ],
		"lines" : [ 			{
				"patchline" : 				{
					"destination" : [ "obj-12", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-1", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-52", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-1", 1 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-13", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-11", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-10", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-12", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-53", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-13", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-14", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-21", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-21", 1 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-52", 2 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-21", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-52", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-56", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-52", 1 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-21", 1 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-53", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-53", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-54", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-54", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-56", 2 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-1", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-6", 0 ]
				}

			}
, 			{
				"patchline" : 				{
					"destination" : [ "obj-6", 0 ],
					"disabled" : 0,
					"hidden" : 0,
					"source" : [ "obj-7", 0 ]
				}

			}
 ],
		"dependency_cache" : [ 			{
				"name" : "patchdescribe.js",
				"bootpath" : "/Applications/Max6/examples/javascript/patcher-scripting",
				"patcherrelativepath" : "../../../../../../../Applications/Max6/examples/javascript/patcher-scripting",
				"type" : "TEXT",
				"implicit" : 1
			}
, 			{
				"name" : "jcom.test.finished.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/Jamoma/Modules/Test/components/test.finished",
				"patcherrelativepath" : "../../../Jamoma/Modules/Test/components/test.finished",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "jcom.test.start.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/Jamoma/Modules/Test/components/test.start",
				"patcherrelativepath" : "../../../Jamoma/Modules/Test/components/test.start",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "jcom.test.assert.equal.old.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/Jamoma/Modules/Test/components/test.assert.equal.old",
				"patcherrelativepath" : "../../../Jamoma/Modules/Test/components/test.assert.equal.old",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "jmod.holoRecControl.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/jmod.holoReccontrol",
				"patcherrelativepath" : "../jmod.holoReccontrol",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "jmod.holoSoundcues~.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/jmod.holoSoundcues",
				"patcherrelativepath" : "../jmod.holoSoundcues",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "jalg.holoSoundcues~.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/jmod.holoSoundcues",
				"patcherrelativepath" : "../jmod.holoSoundcues",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "jmod.holoTransport.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/jmod.holoTransport",
				"patcherrelativepath" : "../jmod.holoTransport",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "jalg.holoOSCRemote.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/jmod.holoTransport",
				"patcherrelativepath" : "../jmod.holoTransport",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "sw.maxpat",
				"bootpath" : "/Applications/Max6/examples/max-tricks/send-receive-tricks/lib",
				"patcherrelativepath" : "../../../../../../../Applications/Max6/examples/max-tricks/send-receive-tricks/lib",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "OSC-unroute2.js",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/Holo-Edit-4.5-UB/Max-HoloPlayer",
				"patcherrelativepath" : "../Holo-Edit-4.5-UB/Max-HoloPlayer",
				"type" : "TEXT",
				"implicit" : 1
			}
, 			{
				"name" : "pathpool.js",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/Holo-Edit-4.5-UB/Max-HoloPlayer",
				"patcherrelativepath" : "../Holo-Edit-4.5-UB/Max-HoloPlayer",
				"type" : "TEXT",
				"implicit" : 1
			}
, 			{
				"name" : "holo.linemode.poly.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/lib/abstractions",
				"patcherrelativepath" : "../lib/abstractions",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "hms.maxpat",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/lib/abstractions/gui",
				"patcherrelativepath" : "../lib/abstractions/gui",
				"type" : "JSON",
				"implicit" : 1
			}
, 			{
				"name" : "playM.gif",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/lib/abstractions/picts",
				"patcherrelativepath" : "../lib/abstractions/picts",
				"type" : "GIFf",
				"implicit" : 1
			}
, 			{
				"name" : "recM.gif",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/lib/abstractions/picts",
				"patcherrelativepath" : "../lib/abstractions/picts",
				"type" : "GIFf",
				"implicit" : 1
			}
, 			{
				"name" : "pauseM.gif",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/lib/abstractions/picts",
				"patcherrelativepath" : "../lib/abstractions/picts",
				"type" : "GIFf",
				"implicit" : 1
			}
, 			{
				"name" : "stopM.gif",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/lib/abstractions/picts",
				"patcherrelativepath" : "../lib/abstractions/picts",
				"type" : "GIFf",
				"implicit" : 1
			}
, 			{
				"name" : "loopM.gif",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/lib/abstractions/picts",
				"patcherrelativepath" : "../lib/abstractions/picts",
				"type" : "GIFf",
				"implicit" : 1
			}
, 			{
				"name" : "preloadM.gif",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/lib/abstractions/picts",
				"patcherrelativepath" : "../lib/abstractions/picts",
				"type" : "GIFf",
				"implicit" : 1
			}
, 			{
				"name" : "backM.gif",
				"bootpath" : "/Users/nilspeters/Documents/gits/JamomaUserLibraries/Holophon/lib/abstractions/picts",
				"patcherrelativepath" : "../lib/abstractions/picts",
				"type" : "GIFf",
				"implicit" : 1
			}
, 			{
				"name" : "jcom.parameter.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.hub.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.oscroute.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.in.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.ui.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.message.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.oscinstance.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.pack≈.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.offset≈.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.meter~.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "oscbonjour.mxo",
				"type" : "iLaX"
			}
, 			{
				"name" : "jcom.savebang.mxo",
				"type" : "iLaX"
			}
 ]
	}

}
