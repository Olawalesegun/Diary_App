package data.repositories;

import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository{
    private List<Entry> entries = new ArrayList<>();
    @Override
    public Entry save(Entry entry) {
        Entry entry1 = findBy(entry.getEntryTitle());
        if(entry1 != null){
            entries.add(entry1);
            return entry;
        }
        return null;
    }

    @Override
    public Entry findBy(String entryTitle) {
        for(Entry entry: entries){
            if(entry.getEntryTitle().equals(entryTitle)){
                return entry;
            }
        }
        return null;
    }

    @Override
    public Entry findBy(int entryID) {
        return null;
    }

    @Override
    public void deleteBy(int entryID) {

    }

    @Override
    public void deleteBy(Entry entry) {

    }

    @Override
    public long count() {
        return 0;
    }
}
