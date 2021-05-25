package com.spreetail.dictionary;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MultiValueMap<K, V> {

	private final Map<K, Set<V>> multimap = new HashMap<>();

	public boolean put(K key, V value) {
		return this.multimap.computeIfAbsent(key, k -> new HashSet<>()).add(value);
	}

	public Set<V> get(K key) {
		return this.multimap.getOrDefault(key, Collections.emptySet());
	}

	public boolean remove(K key, V value) {
		return this.multimap.get(key).remove(value);
	}

	public boolean remove(K key) {
		this.multimap.remove(key);
		return !multimap.containsKey(key);
	}

	public boolean contains(K key, V value) {
		return this.multimap.getOrDefault(key, Collections.emptySet()).contains(value);
	}

	public boolean contains(K key) {
		return this.multimap.containsKey(key);
	}

	public int size() {
		return this.multimap.size();
	}

	public Set<K> keys() {
		return this.multimap.keySet();
	}

	public Set<V> values() {
		return multimap.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
	}

	public boolean clear() {
		multimap.clear();
		return multimap.isEmpty();
	}
}
