package data.repositories;

import data.models.Entry;
public interface EntryRepository {
    Entry save(Entry entry);
    Entry findBy(String entryTitle);
    Entry findBy(int entryID);
    void deleteBy(int entryID);
    void deleteBy(Entry entry);
    long count();
}
