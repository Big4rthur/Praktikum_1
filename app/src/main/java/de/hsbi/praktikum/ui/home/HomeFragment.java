package de.hsbi.praktikum.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import org.w3c.dom.Text;

import de.hsbi.praktikum.MainActivity;
import de.hsbi.praktikum.R;
import de.hsbi.praktikum.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       Button bt = root.findViewById(R.id.button);
       EditText et = root.findViewById(R.id.editText);
       MainActivity mainActivity = (MainActivity) getActivity();

       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mainActivity.addItem(et.getText().toString());
               et.setText("");
           }
       });
       return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}