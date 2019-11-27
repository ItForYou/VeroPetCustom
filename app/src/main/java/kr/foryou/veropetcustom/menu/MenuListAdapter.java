package kr.foryou.veropetcustom.menu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kr.foryou.veropetcustom.R;
import util.Common;
import util.retrofit.MenuList;

public class MenuListAdapter extends ArrayAdapter<MenuList>{
    int iconArray[] = {R.drawable.hash_ico00,R.drawable.hash_ico01,
                         R.drawable.hash_ico02,R.drawable.hash_ico03,
                         R.drawable.hash_ico04,R.drawable.hash_ico05,
                         R.drawable.hash_ico06,R.drawable.hash_ico07,
                         R.drawable.hash_ico_mall
                        };
    int iconArray2[] = {R.drawable.hash_ico00,R.drawable.hash_ico_my,R.drawable.hash_ico01,
            R.drawable.hash_ico02,R.drawable.hash_ico03,
            R.drawable.hash_ico04,R.drawable.hash_ico05,
            R.drawable.hash_ico06,R.drawable.hash_ico07,
            R.drawable.hash_ico_mall
    };
    Context mContext;
    LayoutInflater inflater;
    int resource;

    public MenuListAdapter(@NonNull Context context, int resource, @NonNull List<MenuList> objects) {
        super(context, resource, objects);
        this.mContext=context;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final MenuList menuList=getItem(position);
        final ViewHolder viewHolder = new ViewHolder();

        View view=inflater.inflate(resource,null);
        viewHolder.menuImg=(ImageView)view.findViewById(R.id.menuImg);
        viewHolder.menuTxt=(TextView)view.findViewById(R.id.menuTxt);
        if(Common.getPref(mContext,"mb_id","").equals("")) {
            viewHolder.menuImg.setImageResource(iconArray[position]);
        }else{
            viewHolder.menuImg.setImageResource(iconArray2[position]);
        }
        viewHolder.menuTxt.setText(menuList.getMe_name());
        return view;
    }

    class ViewHolder{
        ImageView menuImg;
        TextView menuTxt;
    }
}
