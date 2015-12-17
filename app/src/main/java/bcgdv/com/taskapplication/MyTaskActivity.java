package bcgdv.com.taskapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MyTaskActivity extends AppCompatActivity {

    ArrayList<Task> mTaskList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_task);
        Button addTaskButton = (Button) findViewById(R.id.taskButton);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t = (EditText) findViewById(R.id.taskName);
                String s = t.getText().toString();
                if (s.isEmpty()) {
                    Toast.makeText(getBaseContext(), "enter the task description first!!",
                            Toast.LENGTH_LONG).show();
                } else {
                    Task task = new Task(s, false);
                    t.setText("");
                    mTaskList.add(task);
                    mAdapter.notifyItemInserted(mTaskList.size()-1);
                    mAdapter.notifyDataSetChanged();
                }
            }
        });


        mRecyclerView = (RecyclerView) findViewById(R.id.task_recycler_view);
        mTaskList = new ArrayList<>();
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyTaskAdapter(mTaskList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.task_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.select_all:
                return setTaskStatusAndUpdateList(true);
            case R.id.deselect_all:
                return setTaskStatusAndUpdateList(false);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Update the task status based on the menu item selection and
    // then update the list by notifying changes to Recycler View
    private boolean setTaskStatusAndUpdateList(boolean taskselection) {
        if (mTaskList.isEmpty()){
            Toast.makeText(getBaseContext(), "Add a task first!!",
                    Toast.LENGTH_LONG).show();
        } else {
            for(Task currentTask: mTaskList) {
                currentTask.setStatus(taskselection);
            }
            mAdapter.notifyItemRangeInserted(0,mTaskList.size()-1);
            mAdapter.notifyDataSetChanged();
        }
        return true;
    }

}
