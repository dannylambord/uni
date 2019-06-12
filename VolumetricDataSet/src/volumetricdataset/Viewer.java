/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volumetricdataset;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author danny
 */
public class Viewer {
    
    File file ;
    VolumetricDataSet vds;
    
    public Viewer(){
        
        
            file = new File("C:\\Users\\danny\\Downloads\\statueLeg.raw.gz");
try{
		 //	load	file	into	Volumetric	Data	Set	passing	
//	the	x,	y	&	z	coordinates
            vds = new VolumetricDataSet(file,256,256,256);
		int[][][] data = vds.getVolumeData();
                System.out.println(data);
}
catch (IOException e){
		//	handle	IOException	
}
    }
    

    
}
