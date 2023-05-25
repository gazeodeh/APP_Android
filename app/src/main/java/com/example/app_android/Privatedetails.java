package com.example.app_android;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Privatedetails {



private Image img;
private Button bt;
    protected void onCreate()
    {

img=getView().findViewById(R.id.perphoto);
bt=getView().findViewById(R.id.finishbtn);
    }
    public class personaldetailspenefactor {
        private String EMAILS;
        private String PHONENUM;

        EMAILS=getView().findViewById(R.id.namebenefactor);
        PHONENUM=getView().findViewById(R.id.phonebenefactor);



        public String getPHONENUM() {
            return PHONENUM;
        }



        public String getEMAILS() {
            return EMAILS;
        }




        public  personaldetailspenefactor(String EMAILS, String PHONENUM) {
            this.EMAILS=EMAILS;
            this.PHONENUM=PHONENUM;


        }


        public void setEMAILS(String EMAILS) {
            this.EMAILS = EMAILS;
        }

        public void setPHONENUM(String PHONENUM) {
            this.PHONENUM = PHONENUM;
}





    }
}
