package com.blogspot.thengnet.musicarch;

/**
 * A Plain Old Java Object class for parsing details of a media track.
 */
public class Media {

    private String mediaTitle;
    private String mediaLength; // otherwise long -- when Time conversion is set up

    public Media (String mediaTitle, String mediaLength) {
        this.mediaTitle = mediaTitle;
        this.mediaLength = mediaLength;
    }

    public String getMediaTitle () {
        return this.mediaTitle;
    }

    public String getMediaLength () {
        return this.mediaLength;
    }

}