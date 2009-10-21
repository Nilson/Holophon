/* IMPORTS */
import holoedit.data.*;
import holoedit.functions.*;
import holoedit.gui.*;
import holoedit.util.*;
import holoedit.data.*;
import java.lang.Math;
import java.util.*;

/* USER INIT INSERT */

HoloTraj ht = new HoloTraj();
HoloPoint curPt = new HoloPoint();
Object[] valuesToReturn = new Object[2];
/* AVAILABLE SDIFdataInstances :
"a01-cut.sdif - 1NRG - begin time=0:4:37'041" - Track:1"
with fields : 0=Energy ;
*/

double dateBegin = 27704; // = the begining of the score selection by default
double dur = 1398; // = the length of the score selection by default
SDIFdataForX  = gp.getTrack(0).getSDIFinstance("a01-cut.sdif - 1NRG - begin time=0:4:37'041").getData();


/* INIT */


XvaluesIndex = 0;// champs de la holoSDIFdata

double durPoint = 0.01 * 1000; // millisec
int nbPoints = (int) (dur / durPoint);

double minAngle = 0/360d*2d*Math.PI;
double maxAngle = 360/360d*2d*Math.PI;
double angleRange = maxAngle - minAngle;

double curAngle = 0.0;

min = SDIFdataForX.getHoloDataStat().minVector.get(XvaluesIndex);
max = SDIFdataForX.getHoloDataStat().maxVector.get(XvaluesIndex);
range = SDIFdataForX.getHoloDataStat().rangeVector.get(XvaluesIndex);
Xstep = SDIFdataForX.getDataLength()/nbPoints;


/* PROCESS */

for (Double key: SDIFdataForX.sdifTreeMap.keySet() ) { // DO NOT REMOVE THIS LINE
curPt = new HoloPoint(); // DO NOT REMOVE THIS LINE

curTimePoint = key / 10;
curPt.date = (int) curTimePoint + dateBegin;


if (SDIFdataForX !=null){
curAngle += 50 * SDIFdataForX.getDataAtTime(key).get(0).get(XvaluesIndex);
curPt.setADZ((float)curAngle, (float)100);

}

ht.addElement(curPt); // DO NOT REMOVE THIS LINE
} // DO NOT REMOVE THIS LINE

valuesToReturn[0] = ht;
valuesToReturn[1] = dur;
return valuesToReturn;
