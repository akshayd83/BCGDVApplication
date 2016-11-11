package bcgdv.com.taskapplication;

/**
 * Created by Akshay
 * RecyclerView Adapter responsible to add or update tasks
 */

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyTaskAdapter extends RecyclerView.Adapter<MyTaskAdapter.ViewHolder> {
    private ArrayList<Task> mDataset;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView taskText;
        public CheckBox taskCheckBox;
        public RelativeLayout myTaskLayout;

        public ViewHolder(View v) {
            super(v);
            myTaskLayout = (RelativeLayout) v.findViewById(R.id.myTaskItem);
            taskText = (TextView) v.findViewById(R.id.taskText);
            taskCheckBox = (CheckBox) v.findViewById(R.id.taksCheckBox);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyTaskAdapter(ArrayList<Task> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyTaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        mContext = parent.getContext();
        View v = LayoutInflater.from(mContext).inflate(R.layout.task_list_view, parent, false);
        // set the view's size, margins, padding and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Task myTask = mDataset.get(position);
        holder.taskText.setText(mDataset.get(position).getTaskName());
        boolean taskStatus = mDataset.get(position).getStatus();

        holder.taskCheckBox.setChecked(taskStatus);
        //update the row color based on task status
        //green if done , white if clear
        if (taskStatus) {
            holder.myTaskLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.green));
        } else {
            holder.myTaskLayout.setBackgroundColor(Color.WHITE);
        }
        holder.taskCheckBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.taskCheckBox.isChecked()) {
                    mDataset.get(position).setStatus(true);
                    holder.myTaskLayout.setBackgroundColor(ContextCompat.getColor(mContext, R.color.green));
                    holder.taskCheckBox.setChecked(mDataset.get(position).getStatus());
                } else {
                    mDataset.get(position).setStatus(false);
                    holder.myTaskLayout.setBackgroundColor(Color.WHITE);
                    holder.taskCheckBox.setChecked(mDataset.get(position).getStatus());
                }

            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
