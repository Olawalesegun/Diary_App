package data.repositories;

import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository{
    private final List<Entry> entries = new ArrayList<>();
    @Override
    public Entry save(Entry entry) {
        Entry newEntryFound = findBy(entry.getEntryTitle());
        if(newEntryFound != null){
            update(entry, newEntryFound);
        }
        else{
            entries.add(entry);
        }
        return entry;
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
    public void update(Entry oldEntry, Entry newEntry){
        int indexOfEntryFound = entries.indexOf(oldEntry);
        entries.set(indexOfEntryFound, newEntry);
    }

    @Override
    public Entry findBy(int entryID) {
        for(Entry entry: entries){
            if(entry.getEntryId() == entryID){
                return entry;
            }
        }
        return null;
    }

    @Override
    public void deleteBy(int entryID) {
       Entry newEntryFound = findBy(entryID);
       if(newEntryFound != null){
           entries.remove(newEntryFound);
       }
    }

    @Override
    public void deleteBy(Entry entry) {
        deleteBy(entry.getEntryId());
    }

    @Override
    public long count() {
        return entries.size();
    }
}
