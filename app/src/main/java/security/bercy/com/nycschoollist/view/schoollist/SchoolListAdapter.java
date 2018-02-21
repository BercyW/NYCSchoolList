package security.bercy.com.nycschoollist.view.schoollist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import security.bercy.com.nycschoollist.R;
import security.bercy.com.nycschoollist.model.School;

/**
 * Created by Bercy on 2/20/18.
 */

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListAdapter.ViewHolder> {

    List<School> schoolList;

    public SchoolListAdapter(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView schoolName;


        public ViewHolder(View itemView) {
            super(itemView);

            schoolName = itemView.findViewById(R.id.tv_school_name);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        School school = schoolList.get(position);


        holder.schoolName.setText(school.getSchoolName());


    }

    @Override
    public int getItemCount() {
        return schoolList.size();
    }


}
