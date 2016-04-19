package kf.qf.com.fgongpermisssion;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by redRose on 2016/3/12 0012.
 */
public class CustomDialog extends Dialog
{

    private TextView mTvLocal;
    private TextView mTvCancel;

    public CustomDialog(Context context) {
        super(context);
        setCustomDialog();
    }

    public CustomDialog(Context context, int theme) {
        super(context, theme);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    public void setCustomDialog(){
       View v= LayoutInflater.from(getContext()).inflate(R.layout.layout_custom_dialog,null);
        mTvLocal = (TextView) v.findViewById(R.id.dialog_local_Updown);
        mTvCancel = (TextView) v.findViewById(R.id.dialog_cancel_Updown);
        super.setContentView(v);
    }
    /**
     * 跳转主界面监听
     * @param listener
     */
    public void setLocalUpDownListener(View.OnClickListener listener){
        mTvLocal.setOnClickListener(listener);
    }

    /**
     * 取消监听
     * @param listener
     */
    public void setCancelUpDownListener(View.OnClickListener listener){
        mTvCancel.setOnClickListener(listener);
    }

}
