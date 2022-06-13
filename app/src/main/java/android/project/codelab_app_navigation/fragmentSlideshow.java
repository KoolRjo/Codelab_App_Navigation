package android.project.codelab_app_navigation;

import android.os.Bundle;
import android.project.codelab_app_navigation.databinding.FragmentSlideshowBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentSlideshow extends Fragment {
    private FragmentSlideshowBinding binding;
    protected TextView tvSlideshow;
    private void getAllViews(){
        tvSlideshow = binding.textSlideshow;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        binding = FragmentSlideshowBinding.inflate(inflater,container,false);
        view = binding.getRoot();
        getAllViews();
        tvSlideshow.setText(getString(R.string.text_slideshow));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
