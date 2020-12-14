package com.excalibur.funwithgles.cropimage.b612crop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.excalibur.funwithgles.R;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C1085pd;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C1956Xx;
import com.excalibur.funwithgles.cropimage.b612crop.defpkg.C3905oka;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import java.util.ArrayList;
import java.util.List;

public final class EditCropItemAdapter extends RecyclerView.Adapter<EditCropItemAdapter.ViewHolder> {
    private final C1956Xx<b> YFa;
    private final List<b> items = new ArrayList();

    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgCropType;
        public TextView txtCropType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            C3905oka.e(view, "itemView");
            ButterKnife.bind(this, view);
        }
    }

    public static final class ViewHolder_ViewBinding implements Unbinder {
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            viewHolder.imgCropType = (ImageView) C1085pd.c(view, R.id.img_thumbnail, "field 'imgCropType'", ImageView.class);
            viewHolder.txtCropType = (TextView) C1085pd.c(view, R.id.txt_name, "field 'txtCropType'", TextView.class);
        }

        @Override
        public void unbind() {

        }
    }

    public EditCropItemAdapter(C1956Xx<b> xx) {
        C3905oka.e(xx, "checkSelectedItemListener");
        this.YFa = xx;
        for (b bVar : b.values()) {
            if (bVar.Mia()) {
                this.items.add(bVar);
            }
        }
    }

    public final int b(b bVar) {
        C3905oka.e(bVar, "cropType");
        int size = this.items.size();
        for (int i = 0; i < size; i++) {
            if (bVar == this.items.get(i)) {
                return i;
            }
        }
        return 0;
    }

    public final b getItem(int i) {
        return this.items.get(i);
    }

    public int getItemCount() {
        return this.items.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        C3905oka.e(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_edit_photo_edit, parent, false);
        C3905oka.d(inflate, "view");
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder vVar, int i) {
        ViewHolder viewHolder = (ViewHolder) vVar;
        C3905oka.e(viewHolder, "holder");
        b bVar = this.items.get(i);
        boolean a = this.YFa.a(bVar);
        C3905oka.e(bVar, "cropType");
        ImageView imageView = viewHolder.imgCropType;
        if (imageView != null) {
            imageView.setImageResource(bVar.Kia());
            ImageView imageView2 = viewHolder.imgCropType;
            if (imageView2 != null) {
                imageView2.setSelected(a);
                TextView textView = viewHolder.txtCropType;
                if (textView != null) {
                    textView.setText(bVar.getTitle());
                    TextView textView2 = viewHolder.txtCropType;
                    if (textView2 != null) {
                        textView2.setSelected(a);
                    } else {
                        C3905oka.Pf("txtCropType");
                        throw null;
                    }
                } else {
                    C3905oka.Pf("txtCropType");
                    throw null;
                }
            } else {
                C3905oka.Pf("imgCropType");
                throw null;
            }
        } else {
            C3905oka.Pf("imgCropType");
            throw null;
        }
    }


}