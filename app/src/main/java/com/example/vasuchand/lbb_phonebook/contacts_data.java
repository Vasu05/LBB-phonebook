package com.example.vasuchand.lbb_phonebook;



/**
 * Created by Vasu Chand on 5/3/2017.
 */
import android.net.Uri;

public class contacts_data
{
    private String number,name;
    Uri image;

    public void setImage(Uri image) {
        this.image = image;
    }

    public Uri getImage() {

        return image;
    }

    public contacts_data(String number, String name, Uri image) {

        this.number = number;
        this.name = name;
        this.image = image;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {

        this.number = number;
    }

    public String getNumber() {

        return number;
    }

    public String getName() {
        return name;
    }


}
