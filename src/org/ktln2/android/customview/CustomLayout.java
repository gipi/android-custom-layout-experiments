package org.ktln2.android.customview;

import android.view.ViewGroup;
import android.view.View;
import android.content.Context;
import android.util.AttributeSet;


/*
 * This layout will mimic the behaviour of LinearLayout (without
 * gravity handling of course).
 *
 * The children are placed vertically with the same size unless one of
 * them has an "match_parent" attribute.
 */
public class CustomLayout extends ViewGroup {
    private final String TAG = "CustomLayout";

    public CustomLayout(Context context) {
        super(context);
        android.util.Log.d(TAG, "CustomLayout(context)");
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        android.util.Log.d(TAG, "CustomLayout(context, attrs)");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        android.util.Log.d(TAG, "onMeasure()");
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    /*
     * We are using directly left, right since we want that the childs fill
     * all the width.
     */
    @Override
    public void onLayout(boolean changed,int left,int top,int right, int bottom) {
        android.util.Log.d(TAG, "onLayout()");

        top = 0;
        for (int cycle = 0, nChild = getChildCount() ; cycle < nChild ; cycle++) {
            View child = getChildAt(cycle);
            int childHeight = child.getMeasuredHeight();

            child.layout(left, top, right, top + childHeight);

            top += childHeight;
        }
    }
}
