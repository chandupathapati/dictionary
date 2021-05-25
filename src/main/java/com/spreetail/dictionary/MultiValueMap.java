package com.spreetail.dictionary;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MultiValueMap<K, V> {

	private final Map<K, Set<V>> multiValuemap = new HashMap<>();

	public boolean put(K key, V value) {
		return this.multiValuemap.computeIfAbsent(key, k -> new HashSet<>()).add(value);
	}

	public Set<V> get(K key) {
		return this.multiValuemap.getOrDefault(key, Collections.emptySet());
	}

	public boolean remove(K key, V value) {
		return this.multiValuemap.get(key).remove(value);
	}

	public boolean remove(K key) {
		this.multiValuemap.remove(key);
		return !multiValuemap.containsKey(key);
	}

	public boolean contains(K key, V value) {
		return this.multiValuemap.getOrDefault(key, Collections.emptySet()).contains(value);
	}

	public boolean contains(K key) {
		return this.multiValuemap.containsKey(key);
	}

	public int size() {
		return this.multiValuemap.size();
	}

	public Set<K> keys() {
		return this.multiValuemap.keySet();
	}

	public Set<V> values() {
		return multiValuemap.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
	}

	public boolean clear() {
		multiValuemap.clear();
		return multiValuemap.isEmpty();
	}
}
