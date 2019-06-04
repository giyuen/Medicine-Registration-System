/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpro2;

/**
 *
 * @author ooigi
 */
public class Medicine {
String medName;String medCode;String medCate;String medDrowsiness;

Medicine(){  
}    

Medicine (String medName, String medCode, String medCate, String medDrowsiness){
    this.medName= medName;
    this.medCode= medCode;
    this.medCate= medCate;
    this.medDrowsiness= medDrowsiness;
}


   
void setMedName(String medName){
    this.medName=medName;
}

void setMedCode(String medCode){
    this.medCode= medCode;
}

void setMedCate(String medCate){
    this.medCate = medCate;
}

void setMedDrowsiness(String medDrowsiness){
    this.medDrowsiness = medDrowsiness;
}

String getMedName(){
    return medName;
}

String getMedCode(){
    return medCode;
}

String getMedCate(){
    return medCate;
}

String getMedDrowsiness(){
    return medDrowsiness;
}

}    

