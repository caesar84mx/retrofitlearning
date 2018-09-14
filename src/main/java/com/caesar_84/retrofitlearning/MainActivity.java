package com.caesar_84.retrofitlearning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.caesar_84.retrofitlearning.model.Hero;
import com.caesar_84.retrofitlearning.util.HeroesAdapter;
import com.caesar_84.retrofitlearning.util.HeroesApi;
import com.caesar_84.retrofitlearning.util.config.RetrofitlearningApp;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @Inject
    Retrofit retrofit;

    @BindView(R.id.tvWelcome)
    TextView tvWelcome;

    @BindView(R.id.pbLoad)
    ProgressBar pbLoad;

    @BindView(R.id.mainLayout)
    LinearLayout mainLayout;

    @BindView(R.id.lvMain)
    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ((RetrofitlearningApp) getApplication()).getGlobalConfigComponent().inject(this);

        HeroesApi heroesApi = retrofit.create(HeroesApi.class);
        Call<List<Hero>> call = heroesApi.getAll();
        call.enqueue(new HeroesCallback());
    }

    private class HeroesCallback implements Callback<List<Hero>>, AdapterView.OnItemClickListener {
        @Override
        public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
            if (!(response.body() == null || response.body().isEmpty())) {
                List<Hero> heroes = response.body();

                HeroesAdapter adapter = new HeroesAdapter(getApplicationContext(), heroes);
                lvMain.setAdapter(adapter);
                lvMain.setOnItemClickListener(adapter);

                swapViews(pbLoad, lvMain);
            } else {
                tvWelcome.setText("No heroes found");
                Toast.makeText(getApplicationContext(), "No heroes found", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<List<Hero>> call, Throwable t) {
            Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            tvWelcome.setText("No access to Valhalla");
        }

        private void swapViews(View v1, View v2) {
            v1.setVisibility(View.GONE);
            v2.setVisibility(View.VISIBLE);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }
}
