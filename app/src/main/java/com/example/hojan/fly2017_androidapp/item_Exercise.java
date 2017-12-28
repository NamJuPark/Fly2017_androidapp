package com.example.hojan.fly2017_androidapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 박남주 on 2017-08-14.
 */

public class item_Exercise implements Parcelable{
    int exerno;
    String exerName;
    String exerCaption;
    String exerLink;

    public item_Exercise(int exerno, String exerName, String exerCaption, String exerLink){
        this.exerno = exerno;
        this.exerName = exerName;
        this.exerCaption = exerCaption;
        this.exerLink = exerLink;
    }

    protected item_Exercise(Parcel in) {
        exerno = in.readInt();
        exerName = in.readString();
        exerCaption = in.readString();
        exerLink = in.readString();
    }

    public static final Creator<item_Exercise> CREATOR = new Creator<item_Exercise>() {
        @Override
        public item_Exercise createFromParcel(Parcel in) {
            return new item_Exercise(in);
        }

        @Override
        public item_Exercise[] newArray(int size) {
            return new item_Exercise[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(exerno);
        parcel.writeString(exerName);
        parcel.writeString(exerCaption);
        parcel.writeString(exerLink);
    }
}
