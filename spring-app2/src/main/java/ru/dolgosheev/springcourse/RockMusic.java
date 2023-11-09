package ru.dolgosheev.springcourse;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RockMusic implements Music {
    private final List<String> rockMusicPlaylist = Arrays.asList("Wind cries Mary", "We will rock you", "Highway to hell");
    @Override
    public String getSong(int i) {
        return rockMusicPlaylist.get(i);
    }
}
