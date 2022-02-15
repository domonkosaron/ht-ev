package hu.domonkosaron.ht.task1.domain.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandServiceImpl implements RandService {
    @Override
    public String rand(int x) {
        Random random = new Random();
        final String rand = String.valueOf( random.ints(1, x)
                .findFirst()
                .getAsInt());
        return rand;
    }
}
