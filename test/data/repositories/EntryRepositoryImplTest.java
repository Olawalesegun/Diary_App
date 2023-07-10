package data.repositories;

import data.models.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoryImplTest {
    EntryRepository entryRepo;
    @BeforeEach
    void setUp(){
        entryRepo = new EntryRepositoryImpl();
    }
    @Test
    public void saveOneEntry_countThatOneEntryIsSavedTest(){
        Entry entry = new Entry();
        entry.setEntryTitle("My Experience Today");
        entry.setEntryBody("Shalewa was in the wardrobe hiding");
        entryRepo.save(entry);
        assertEquals(1, entryRepo.count());
    }
    @Test
    public void saveTwoEntry_countThatTwoEntryWasSavedTest(){
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        entry1.setEntryTitle("Pojos news");
        entry1.setEntryBody("Baba blaship hav eyou any wool");
        entryRepo.save(entry1);
        entry2.setEntryTitle("Personal Infos");
        entry2.setEntryBody("Body is banging");
        entryRepo.save(entry2);
        assertEquals(2, entryRepo.count());

    }

}