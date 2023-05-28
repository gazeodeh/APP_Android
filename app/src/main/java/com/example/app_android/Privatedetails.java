package com.example.app_android;

import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Privatedetails {

        private String EMAILS;
        private String PHONENUM;





        public String getPHONENUM() {
            return PHONENUM;
        }



        public String getEMAILS() {
            return EMAILS;
        }
        public  Privatedetails(String EMAILS, String PHONENUM) {
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
