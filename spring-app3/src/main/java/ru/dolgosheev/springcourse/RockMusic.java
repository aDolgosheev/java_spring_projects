package ru.dolgosheev.springcourse;

import java.util.Arrays;
import java.util.List;

//@Component
public class RockMusic implements Music {
    private final List<String> musicPlaylist = Arrays.asList("Wind cries Mary", "We will rock you", "Highway to hell");
    @Override
    public String getSong(int i) {
        return musicPlaylist.get(i);
    }
}
