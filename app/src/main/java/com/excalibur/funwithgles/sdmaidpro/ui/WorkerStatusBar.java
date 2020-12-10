package com.excalibur.funwithgles.sdmaidpro.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.excalibur.funwithgles.R;
import com.excalibur.funwithgles.sdmaidpro.epack.y;
import com.excalibur.funwithgles.sdmaidpro.model.o;

import java.util.Locale;

import butterknife.ButterKnife;
import me.zhanghai.android.materialprogressbar.HorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable;

public class WorkerStatusBar extends ConstraintLayout {
    public View cancelButton;
    public TextView counter;
    public TextView primaryText;
    public SDMProgressBar progressBar;
    public TextView secondaryText;

    public WorkerStatusBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.extra_workerstatusbar_view, this);
    }

    public void a(View.OnClickListener onClickListener, View view) {
        this.cancelButton.setVisibility(View.INVISIBLE);
        onClickListener.onClick(view);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(16843499, typedValue, true)) {
            setLayoutParams(new ConstraintLayout.LayoutParams(-1, TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics())));
        }
        ButterKnife.bind(this, this);
        this.progressBar.setVisibility(View.INVISIBLE);
        this.counter.setVisibility(View.INVISIBLE);
        IndeterminateHorizontalProgressDrawable indeterminateHorizontalProgressDrawable = new IndeterminateHorizontalProgressDrawable(getContext());
        indeterminateHorizontalProgressDrawable.setShowBackground(true);
        indeterminateHorizontalProgressDrawable.setUseIntrinsicPadding(false);
        this.progressBar.setIndeterminateDrawable(indeterminateHorizontalProgressDrawable);
        HorizontalProgressDrawable horizontalProgressDrawable = new HorizontalProgressDrawable(getContext());
        horizontalProgressDrawable.setShowBackground(true);
        horizontalProgressDrawable.setUseIntrinsicPadding(false);
        this.progressBar.setProgressDrawable(horizontalProgressDrawable);
    }

    public void setCancelButtonListener(View.OnClickListener onClickListener) {
        this.cancelButton.setOnClickListener(new y(this, onClickListener));
    }

    public void setStatus(com.excalibur.funwithgles.sdmaidpro.model.o oVar) {
        this.primaryText.setText(oVar.c);
        this.secondaryText.setText(oVar.d);
        int i = 8;
        this.secondaryText.setVisibility(TextUtils.isEmpty(oVar.d) ? View.GONE : View.VISIBLE);
        o.bEnum bVar = oVar.f671e;
        if (bVar == o.bEnum.INDETERMINATE) {
            this.progressBar.setProgress(0);
            this.progressBar.setMax(0);
            if (!this.progressBar.isIndeterminate()) {
                this.progressBar.setIndeterminate(true);
            }
        } else if (bVar == o.bEnum.DETERMINATE) {
            if (this.progressBar.isIndeterminate()) {
                this.progressBar.setIndeterminate(false);
            }
            this.progressBar.setMax(oVar.b);
            this.progressBar.setProgress(oVar.a);
        }
        this.progressBar.setVisibility(oVar.f671e != o.bEnum.NONE ? View.VISIBLE : View.INVISIBLE);
        o.bEnum bVar2 = oVar.f671e;
        if (bVar2 == o.bEnum.INDETERMINATE) {
            this.counter.setText((CharSequence) null);
        } else if (bVar2 == o.bEnum.DETERMINATE) {
            if (oVar.b == 100) {
                this.counter.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf(this.progressBar.getProgress())}));
            } else {
                this.counter.setText(String.format(Locale.getDefault(), "%d/%d", new Object[]{Integer.valueOf(this.progressBar.getProgress()), Integer.valueOf(this.progressBar.getMax())}));
            }
        }
        this.counter.setVisibility(oVar.f671e == o.bEnum.DETERMINATE ? View.VISIBLE : View.GONE);
        this.cancelButton.setVisibility(oVar.f ? View.VISIBLE : View.GONE);
        if (oVar.g) {
            i = 0;
        }
        setVisibility(i);
    }
}