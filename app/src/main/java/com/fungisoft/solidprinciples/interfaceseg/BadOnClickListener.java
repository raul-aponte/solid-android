package com.fungisoft.solidprinciples.interfaceseg;

// no client should be forced to depend on methods it does not use
public interface BadOnClickListener {
    void onClick();
    void onTouch();
    void onLongClick();
}
