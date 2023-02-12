package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
@RestController
@RequestMapping("/")
public class NewsController {
    private ArrayList<SerialItem> serialItems = new ArrayList<>();
    public NewsController() {
        try {
            serialItems.add(new SerialItem("Нация Z",
                    "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/4cd2abd6-6a45-45b7-8f1e-8ea8dd491e07/300x450",
                    "2014", 1, 5, 68, 43*60, 6.8,
                    new ArrayList<>(Arrays.asList("ужасы", "фантастика", "боевик", "драма", "мелодрама", "комедия")),
                    "https://www.kinopoisk.ru/series/841371/"));
            serialItems.add(new SerialItem("Ходячие мертвецы",
                    "https://avatars.mds.yandex.net/get-kinopoisk-image/1898899/c50dd27b-9ac0-42d1-bc9a-6fae8adc1566/300x450",
                    "2010", 2, 11, 147, 43*60, 7.0,
                    new ArrayList<>(Arrays.asList("ужасы", "драма", "триллер")),
                    "https://www.kinopoisk.ru/series/508161/"));
            serialItems.add(new SerialItem("Метод",
                    "https://avatars.mds.yandex.net/get-kinopoisk-image/1773646/ef2e1e88-7ca2-42dd-a2ab-9c1b976ac9b0/300x450",
                    "2015", 3, 2, 32, 53*60, 8.1,
                    new ArrayList<>(Arrays.asList("криминал", "драма", "триллер")),
                    "https://www.kinopoisk.ru/series/838050/"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @GetMapping("/all")
    public Iterable<SerialItem> allSerial(){
        return serialItems;
    }
    @GetMapping("/rating")
    public Optional<SerialItem> serialByRating(@RequestParam(value = "rating", defaultValue = "0") String rating){
        for (SerialItem e: serialItems) {
            if(e.getRating() > Double.parseDouble(rating)){
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }
    @PostMapping("/new")
    public Optional<SerialItem> createSerial(@RequestBody SerialItem item) {
        serialItems.add(item);
        return Optional.of(item);
    }
    @DeleteMapping("/all/{id}")
    public void deleteSerialItem(@PathVariable int id) {
        serialItems.removeIf(t -> t.getId() == id);
    }
}
