package android.project.codelab_app_navigation;

import android.os.Bundle;
import android.project.codelab_app_navigation.databinding.FragmentHomeBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.button.MaterialButton;

public class fragmentHome extends Fragment {
    private FragmentHomeBinding binding;
    protected TextView tvHome;
    protected MaterialButton btnClick;
    private void getAllView(){
        tvHome = binding.textHome;
        btnClick = binding.button;
    }
    private void navigateToGallery(){
        btnClick.setOnClickListener(view -> {
            NavHostFragment.findNavController(this).navigate(R.id.action_fragmentHome_to_fragmentGallery);
        });
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        view = binding.getRoot();
        getAllView();
        tvHome.setText(getString(R.string.text_home));
        navigateToGallery();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
