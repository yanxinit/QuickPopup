package com.yanxin.quickpopup.library;

import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by YanXin on 2016/7/1.
 */
public class QuickPopup {

    private View mRelativeView;
    private View mContentView;

    private int mLocation;
    private int mOffsetX;
    private int mOffsetY;
    private PopupWindow mPopupWindow;

    public interface Location {
        int TOP = 0;
        int BOTTOM = 1;
    }

    public QuickPopup with(View relativeView) {
        mRelativeView = relativeView;
        return this;
    }

    public QuickPopup setContentView(View contentView) {
        mContentView = contentView;
        return this;
    }

    public QuickPopup location(int location) {
        mLocation = location;
        return this;
    }

    public QuickPopup offsetX(int offsetX) {
        mOffsetX = offsetX;
        return this;
    }

    public QuickPopup offsetY(int offsetY) {
        mOffsetY = offsetY;
        return this;
    }

    public void show() {
        mContentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        mPopupWindow = new PopupWindow(
                mContentView,
                mContentView.getMeasuredWidth(),
                mContentView.getMeasuredHeight(),
                true);

        mPopupWindow.setOutsideTouchable(true);

        int offsetXToCenter = (mRelativeView.getWidth() - mContentView.getMeasuredWidth()) / 2;

        if (mLocation == Location.BOTTOM)
            mPopupWindow.showAsDropDown(mRelativeView, offsetXToCenter + mOffsetX, mOffsetY);
        else if (mLocation == Location.TOP)
            mPopupWindow.showAsDropDown(mRelativeView, offsetXToCenter + mOffsetX,
                    mOffsetY - mRelativeView.getHeight() - mContentView.getMeasuredHeight());

        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void dismiss() {
        if (mPopupWindow != null && mPopupWindow.isShowing())
            mPopupWindow.dismiss();
    }

}
