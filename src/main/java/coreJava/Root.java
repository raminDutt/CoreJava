package coreJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Collator;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

import annotationProcessor.JavaDocProcessor.Param;
import annotationProcessor.JavaDocProcessor.Return;
import annotationProcessor.TestCaseProcessor.TestCase;
import annotations.Cloneable2;
import annotations.Resource;
import annotations.TestCaseEnigma;
import annotations.Todo;
import framework.IPlugin;

public class Root {

    public static void main(String args[]) throws Exception {

	
	List<IPlugin> iramin = IPlugin.INSTANCE;
	iramin.forEach(plugin -> System.out.println(plugin.getName()));
	System.out.println("The end");

	
    }

    public static String getValueFromCache( Map<Integer, SoftReference<String>> cache) {
	Collection<SoftReference<String>> values = cache.values();
	Iterator<SoftReference<String>> iterator = values.iterator();
	while (iterator.hasNext()) {
	    SoftReference<String> softReference = iterator.next();
	    String cacheValue = softReference.get();
	    if (cacheValue != null) {
		return cacheValue;
	    }
	}
	return null;
    }

    private void mergeSortBck(int[] array, int p, int r) {

	if (p == r) {
	    return;
	}
	int q = (p + r) / 2;
	int z = q + 1;
	int w = r + 1;
	mergeSortBck(array, p, q);
	mergeSortBck(array, z, r);

	int[] lowHalf = Arrays.copyOfRange(array, p, z);
	int[] highHalf = Arrays.copyOfRange(array, z, w);

	int k = p;
	int i = 0;
	int j = 0;
	while (k < w) {

	    if (i == lowHalf.length) {
		array[k] = highHalf[j];
		j++;
	    } else {
		if (j == highHalf.length) {
		    array[k] = lowHalf[i];
		    i++;
		} else {
		    if (lowHalf[i] < highHalf[j]) {
			array[k] = lowHalf[i];
			i++;
		    } else {
			array[k] = highHalf[j];
			j++;
		    }
		}
	    }
	    k++;
	    /*- //Implementation 2
	     * if (lowHalf[i] < highHalf[j]) {
	    array[k] = lowHalf[i];
	    i++;
	    } else {
	    array[k] = highHalf[j];
	    j++;
	    k++;
	    }

	    if (i == lowHalf.length) {
	    while (j < highHalf.length && k < w) {
	        array[k] = highHalf[j];
	        j++;
	        k++;
	    }
	    }

	    if (j == highHalf.length) {
	    while (i < lowHalf.length && k < w) {
	        array[k] = lowHalf[i];
	        i++;
	        k++;
	    }
	    }
	     */
	}

    }

    public static boolean junitAndMockito_ch4Q1_pwdValidation(String pwd) {
	int PASSWORD_MIN_LENGTH = 10;
	int MIN_DIGITS = 3;
	Objects.requireNonNull(pwd, "Password must Not be null");

	if (pwd.length() < PASSWORD_MIN_LENGTH) {
	    return false;
	}

	Pattern pattern = Pattern.compile("[0-9]");
	Matcher matcher = pattern.matcher(pwd);
	int i = 0;
	while (matcher.find()) {
	    i++;
	}

	if (i < MIN_DIGITS) {
	    return false;
	}

	if (!pwd.contains("_") || !pwd.contains("#")) {
	    return false;
	}

	Pattern pattern2 = Pattern.compile("[a-z]+[A-Z]+");
	Matcher matcher2 = pattern2.matcher(pwd);
	if (!matcher2.find()) {
	    return false;
	}
	return true;
    }

    public static String junitAndMockito_ch4Q2_getNumber(String input) {

	Pattern pattern = Pattern.compile("\\d\\d\\d+");
	Matcher matcher = pattern.matcher(input);
	String result = "";
	while (matcher.find()) {
	    if (result.isEmpty()) {
		result = matcher.group();
	    } else {
		result = result + "," + matcher.group();
	    }
	}
	return result;
    }

    public static String junitAndMockito_ch3Q2_reverse(String word) {
	Objects.requireNonNull(word);

	boolean isValidInput = word.codePoints().anyMatch(codePoint -> {
	    if (codePoint < 32 || codePoint >= 127) {
		return false;
	    }
	    return true;
	});

	if (!isValidInput && !word.isEmpty()) {
	    throw new IllegalArgumentException();
	}
	Stack<Character> stack = new Stack<>();
	int length = word.length();

	char[] cs = word.toCharArray();
	for (char c : cs) {
	    stack.push(c);
	}

	StringBuilder builder = new StringBuilder();
	while (!stack.isEmpty()) {
	    builder.append(stack.pop());
	}
	return builder.toString();
    }

    public static void powBTest() {
	System.out.println(powB(2, 0) + " " + powC(2, 0));
	System.out.println(powB(20, 1) + " " + powC(20, 1));
	System.out.println(powB(20, -1) + " " + powC(20, -1));
	System.out.println(powB(2, 5) + " " + powC(2, 5));
	System.out.println(powB(2, -5) + " " + powC(2, -5));
	System.out.println(powB(3, 2) + " " + powC(3, 2));
    }

    public static double powC(double x, int n) {
	if (n == 0) {
	    return 1;
	}

	if (n < 0) {
	    return 1 / powC(x, -n);
	}

	if (n % 2 == 0) {
	    double product = powC(x, n / 2);
	    return product * product;
	} else {
	    return x * powC(x, n - 1);
	}
    }

    public static double powB(double x, int n) {

	if (n == 0) {
	    return 1;
	}

	if (n % 2 == 0) {
	    double product = powB(x, n / 2);
	    return product * product;

	} else {

	    if (n > 0) {
		return x * powB(x, n - 1);
	    } else {
		return 1 / x * powB(x, n + 1);
	    }
	}

    }

    public static double pow(int x, int n) {

	if (n == 0) {
	    return 1;
	} else {
	    if (n > 0) {
		return x * pow(x, n - 1);
	    } else {
		return 1 / (double) x * pow(x, n + 1);

	    }
	}
    }

    public static boolean palindrome2(String word) {
	int length = word.length();
	if (length <= 1)
	    return true;

	if (word.charAt(0) == word.charAt(length - 1)) {
	    String w = word.substring(1, length - 1);
	    return palindrome2(w);
	}
	return false;

    }

    public static void ch13q11() {
	ResourceBundle bundle = ResourceBundle
		.getBundle("coreJava.rb.Ch13Q11rb");
	double[] value = (double[]) bundle.getObject("defaultPaperSize");
	System.out.println(Arrays.toString(value));
    }

    private static void ch13q10() {
	// Not sure how???
	System.out.println(Charset.availableCharsets());
    }

    private static void ch13q9() {

	Function<Locale, String> internationalize = locale -> {

	    ResourceBundle bundle = ResourceBundle.getBundle(
		    "coreJava.LabelsBundle", locale);
	    String template = bundle.getString("message");

	    String formatedMessage = MessageFormat
		    .format(template, "Ramin", 45);
	    return formatedMessage;
	};

	System.out.println(internationalize.apply(Locale
		.getDefault(Category.DISPLAY)));
	System.out.println(internationalize.apply(Locale.GERMAN));
	System.out.println(internationalize.apply(Locale.FRANCE));
	System.out.println(internationalize.apply(Locale.CANADA_FRENCH));
	System.out.println(internationalize.apply(Locale.CANADA));
    }

    private static void ch13q8() {

	// BMP
	IntFunction<String> toHex = codePoint -> Integer.toHexString(codePoint);
	IntPredicate predicate = codepoint -> {
	    if (0 <= codepoint && codepoint <= 127) {
		return true;
	    } else {
		return false;
	    }
	};

	BinaryOperator<String> function = (character, normalizedString) -> {
	    String unicode = character
		    + "("
		    + Arrays.toString(character.codePoints().mapToObj(toHex)
			    .toArray())
		    + ") <--> "
		    + normalizedString
		    + "("
		    + Arrays.toString(normalizedString.codePoints()
			    .mapToObj(toHex).toArray()) + ")";
	    return unicode;
	};

	List<String> result = new ArrayList<>();
	int codePoint = 0;
	while (codePoint <= 0xFFFF) {
	    String character = new String(Character.toChars(codePoint));

	    // NFKD
	    String normalized_NFKD = Normalizer.normalize(character, Form.NFKD);
	    long count_NFKD = normalized_NFKD.codePoints().filter(predicate)
		    .count();
	    String unicode = "";
	    if (count_NFKD >= 2) {
		unicode = " NFKD=" + function.apply(character, normalized_NFKD);
	    }

	    // NFKC
	    String normalized_NFKC = Normalizer.normalize(character, Form.NFKC);
	    long count_NFKC = normalized_NFKC.codePoints().filter(predicate)
		    .count();
	    if (count_NFKC >= 2) {
		unicode = unicode + " NFKC="
			+ function.apply(character, normalized_NFKC);
	    }

	    if (!unicode.isEmpty()) {
		result.add(unicode);
	    }
	    codePoint++;
	}

	result.forEach(System.out::println);

    }

    private static void ch13q7() {
	Map<Locale, List<String>> map = new HashMap<Locale, List<String>>();
	Locale[] locales = Locale.getAvailableLocales();
	for (Locale locale : locales) {
	    List<String> list = new ArrayList<String>();
	    Month[] months = Month.values();
	    for (Month month : months) {

		String displayName = month.getDisplayName(TextStyle.FULL,
			locale);
		String standalone = month.getDisplayName(
			TextStyle.FULL_STANDALONE, locale);

		// check if this is a number
		if (!standalone.matches("\\d*")
			&& !displayName.equals(standalone)) {
		    list.add(displayName + "<->" + standalone);
		}
	    }
	    if (!list.isEmpty()) {
		map.put(locale, list);
	    }
	}

	map.entrySet()
		.stream()
		.forEach(
			entry -> {
			    Locale locale = entry.getKey();
			    System.out.println("----------");
			    System.out.println(locale.getDisplayName() + " "
				    + locale.getCountry());
			    System.out.println("----------");
			    entry.getValue().forEach(System.out::println);

			});
    }

    private static void ch13q6c() {
	Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();
	Map<Currency, Map<String, Set<Locale>>> currencyToSymbolsToLocales = new HashMap<>();
	availableCurrencies
		.forEach(currency -> {
		    Locale[] availableLocales = Locale.getAvailableLocales();
		    Map<String, Set<Locale>> symbolsToLocale = new HashMap<>();
		    for (Locale locale : availableLocales) {
			String symbole = currency.getSymbol(locale);
			Set<Locale> locales = new HashSet<>();
			locales.add(locale);
			BiFunction<Set<Locale>, Set<Locale>, Set<Locale>> remappingFunction = (
				oldValue, newValue) -> {
			    Set<Locale> mergeSet = new HashSet<>(oldValue);
			    mergeSet.addAll(newValue);
			    return mergeSet;
			};
			symbolsToLocale.merge(symbole, locales,
				remappingFunction);
		    }
		    if (symbolsToLocale.keySet().size() >= 2) {
			currencyToSymbolsToLocales.put(currency,
				symbolsToLocale);
		    }
		});

	Iterator<Entry<Currency, Map<String, Set<Locale>>>> iterator1 = currencyToSymbolsToLocales
		.entrySet().iterator();

	while (iterator1.hasNext()) {
	    Entry<Currency, Map<String, Set<Locale>>> entry1 = iterator1.next();
	    Currency currency = entry1.getKey();

	    String symboles = "";

	    Iterator<Entry<String, Set<Locale>>> iterator2 = entry1.getValue()
		    .entrySet().iterator();
	    while (iterator2.hasNext()) {

		Entry<String, Set<Locale>> entry2 = iterator2.next();
		String currencySymbole = entry2.getKey();
		String localesString = "{";
		Set<Locale> locales = entry2.getValue();
		Iterator<Locale> iterator3 = locales.iterator();
		while (iterator3.hasNext()) {
		    localesString = localesString
			    + iterator3.next().getDisplayName();
		    if (iterator3.hasNext()) {
			localesString = localesString + ",";
		    }

		}
		localesString = localesString + "}";

		symboles = symboles + "(" + currencySymbole + ", "
			+ localesString + ")";
		if (iterator2.hasNext()) {
		    symboles = symboles + ",";
		}
	    }

	    System.out.println(currency.getDisplayName() + "->" + symboles);

	}

    }

    public static boolean polindrome(String word) {
	if (word.length() <= 1)
	    return true;
	int length = word.length();
	if (word.charAt(0) == word.charAt(length - 1)) {
	    String sub = word.substring(1, length - 1);
	    return polindrome(sub);
	}
	return false;
    }

    public static boolean polindrome(String word, int index) {
	if (word.length() <= 1)
	    return true;

	int length = word.length();
	if (length % 2 == 0) {
	    if (word.charAt(index) == word.charAt(length - 1 - index)) {
		if (index < length / 2) {
		    return polindrome(word, ++index);
		}
		return true;
	    }
	} else {
	    if (word.charAt(index) == word.charAt(length - 1 - index)) {
		if (index < length / 2 + 1) {
		    return polindrome(word, ++index);
		}
		return true;
	    }
	}

	return false;

    }

    public static void ch13q6b() {
	Set<Currency> availableCurrencies = Currency.getAvailableCurrencies();

	/**
	 * This transforms a Map<String,String> to Map<String,Set<Set>>
	 */
	BiFunction<Map<String, Set<String>>, Map<String, String>, Map<String, Set<String>>> accumulator = (
		i, t) -> {
	    Set<String> set = new HashSet<>(t.values());
	    String k = t.keySet().iterator().next();
	    i.put(k, set);
	    return i;
	};

	BinaryOperator<Map<String, Set<String>>> combiner = (m1, m2) -> {
	    Map<String, Set<String>> mapMerge = new HashMap<>(m1);
	    m2.entrySet().forEach(
		    entry -> {
			mapMerge.merge(entry.getKey(), entry.getValue(), (set1,
				set2) -> {
			    Set<String> setMerge = new HashSet<>(set1);
			    setMerge.addAll(set2);
			    return setMerge;
			});
		    });
	    return mapMerge;
	};
	availableCurrencies
		.stream()
		.map(currency -> {
		    Map<String, Set<String>> identity = new HashMap<>();

		    Map<String, Set<String>> reduced = Stream
			    .of(Locale.getAvailableLocales())
			    .map(locale -> {
				Map<String, String> map = new HashMap<String, String>();
				map.put(currency.getSymbol(locale),
					locale.getDisplayName());
				return map;
			    }).reduce(identity, accumulator, combiner);
		    if (reduced.values().size() >= 2) {
			Map<String, Map<String, Set<String>>> m = new HashMap<>();
			m.put(currency.getDisplayName(), reduced);
			return m;
		    } else {
			return null;
		    }

		}).filter(map -> {
		    if (map == null) {
			return false;
		    } else {
			return true;
		    }
		}).forEach(System.out::println);
    }

    public static void ch13q6() {

	/*
	 * Currency currency =
	 * NumberFormat.getCurrencyInstance(Locale.US).getCurrency();
	 * 
	 * System.out.println(currency + " " +currency.getSymbol());
	 * 
	 * Currency.getAvailableCurrencies().forEach(System.out::println);
	 */

	Map<Currency, Map<Locale, String>> map = new HashMap<Currency, Map<Locale, String>>();

	Set<Currency> currencies = Currency.getAvailableCurrencies();
	for (Currency currency : currencies) {
	    Map<Locale, String> map2 = new HashMap<Locale, String>();
	    Locale[] locales = Locale.getAvailableLocales();
	    for (Locale locale : locales) {
		String symbol = currency.getSymbol(locale);

		map2.put(locale, symbol);
	    }
	    map.put(currency, map2);
	}

	map.entrySet()
		.stream()
		.filter(entry -> {
		    long count = entry.getValue().values().stream().distinct()
			    .count();
		    if (count >= 2) {
			return true;
		    } else {
			return false;
		    }

		})
		.forEach(
			entry -> {
			    String currencyName = entry.getKey()
				    .getDisplayName();
			    Stream<Entry<Locale, String>> stream = entry
				    .getValue().entrySet().stream();

			    Map<String, Set<String>> symbolsToLocale = stream.collect(Collectors
				    .toMap(entryLocaleToSymb -> entryLocaleToSymb
					    .getValue(),
					    entryLocaleToSymb -> Collections
						    .singleton(entryLocaleToSymb
							    .getKey()
							    .getDisplayName())

					    ,
					    (symb1, symb2) -> {
						Set<String> symbols = new HashSet<>(
							symb1);
						symbols.addAll(symb2);
						return symbols;
					    }));

			    symbolsToLocale.forEach((k, v) -> {
				System.out.println(currencyName + "-> " + k
					+ "->" + v);
			    });
			});

    }

    public static void ch13q5() {
	Locale canadaLocale = Locale.CANADA;
	Locale[] locales = Locale.getAvailableLocales();
	Comparator<? super String> comparator = Collator
		.getInstance(canadaLocale);
	Set<String> currencies = new TreeSet<>(comparator);
	for (Locale locale : locales) {
	    String currency = NumberFormat.getCurrencyInstance(locale)
		    .getCurrency().getDisplayName(canadaLocale);

	    if (!currency.isEmpty()) {
		currencies.add(currency);
	    }
	}
	currencies.forEach(System.out::println);
    }

    public static void ch13q4() {
	Locale canadaLocale = Locale.CANADA;
	Comparator<Object> comparator = Collator.getInstance(canadaLocale);
	Set<String> set = new TreeSet<String>(comparator);
	Locale[] locales = Locale.getAvailableLocales();
	List<String> list = new ArrayList<>();
	for (Locale locale : locales) {
	    String language = locale.getDisplayLanguage(canadaLocale);
	    if (!language.isEmpty()) {
		set.add(language);
		list.add(language);
	    }

	}

	set.forEach(System.out::println);
	System.out.println("size=" + set.size());
	System.out.println("size=" + list.size());

    }

    public static void ch13Q3() {
	Locale usa = Locale.US;
	DateTimeFormatter usaFormatter = DateTimeFormatter.ofLocalizedDate(
		FormatStyle.FULL).withLocale(usa);

	LocalDateTime now = LocalDateTime.now();
	String usaDateTime = usaFormatter.format(now);
	Locale[] locales = Locale.getAvailableLocales();
	for (Locale locale : locales) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(
		    FormatStyle.FULL).withLocale(locale);
	    String dateTime = formatter.format(now);
	    if (usaDateTime.equals(dateTime)) {
		System.out.println(locale + " " + locale.getDisplayName()
			+ ": " + usaDateTime + "->" + dateTime);
	    }
	}

    }

    public static void ch13Q2() {

	Locale[] locales = Locale.getAvailableLocales();

	for (Locale locale : locales) {
	    NumberFormat format = NumberFormat.getNumberInstance(locale);
	    String result = format.format(Double.parseDouble("123456789"));
	    String array[] = result.split("\\D+");

	    String result2 = Stream.of(array).collect(Collectors.joining());

	    if (!result2.equals("123456789")) {
		System.out.println(locale + ":" + result + "->" + result2);
	    }
	}
    }

    public static void ch13Q1() {
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter franceFormatter = DateTimeFormatter.ofLocalizedDate(
		FormatStyle.FULL).withLocale(Locale.FRANCE);
	DateTimeFormatter chineFormatter = DateTimeFormatter.ofLocalizedDate(
		FormatStyle.FULL).withLocale(Locale.CHINA);
	Locale thailand = new Locale.Builder().setRegion("TH")
		.setLanguage("Thai").setScript("Thai").build();
	DateTimeFormatter thailandFormatter = DateTimeFormatter
		.ofLocalizedDate(FormatStyle.FULL).withLocale(thailand);
	System.out.println(franceFormatter.format(now));
	System.out.println(chineFormatter.format(now));
	System.out.println(thailandFormatter.format(now));

    }

    private static void factorial2() {

	System.out.println("The value of 5! should be " + 5 * 4 * 3 * 2 * 1);
	System.out.println("The value of 5! is " + fact_2(5));
	System.out.println("The value of 0! should be 1");
	System.out.println("The value of 0! is " + fact_2(0));
	// Assert.assertEquals(fact_2(5), 120);
	// Assert.assertEquals(fact_2(0), 1);
    }

    private static int fact(int n) {
	int result = 1;
	int i = 1;
	while (i <= n) {
	    result = result * i;
	    i++;
	}
	return result;
    }

    private static int fact_2(int n) {
	int result = 0;
	if (n == 0) {
	    result = 1;
	} else {
	    result = n * fact(n - 1);
	}
	return result;

    }

    private static void insertionSort() {
	Random generator = new Random();
	int[] array = generator.ints(0, 100).limit(10).toArray();
	int i = 1;
	int size = array.length;
	System.out.println(Arrays.toString(array));
	while (i < size) {
	    int j = i - 1;
	    int min = array[i];
	    while (j >= 0 && array[j] > min) {

		array[j + 1] = array[j];
		j--;
	    }
	    array[j + 1] = min;
	    i++;
	}

	System.out.println(Arrays.toString(array));
    }

    private static void ch12Q12() {

	Root root = new Root();
	Observer observer_africa = root.new Observer("Africa/Asmera");
	Observer observer_losAneles = root.new Observer("America/Los_Angeles");
	Observer observer_berlin = root.new Observer("Europe/Berlin");

	AppointmentServer appointmentServer = root.new AppointmentServer();
	appointmentServer
		.setAppointment(
			"Java Core",
			"This is an appointment aimed at discussing key Java 8 features",
			ZonedDateTime.now().plusMinutes(1));

	appointmentServer.register(observer_berlin);
	appointmentServer.register(observer_losAneles);
	appointmentServer.register(observer_africa);
	try {
	    appointmentServer.start();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    public class Observer {
	ZoneId zoneId = null;

	public Observer(String zoneId) {
	    this.zoneId = ZoneId.of(zoneId);
	}

	public void appointmentReminder(
		AppointmentServer.Appointment appointment) {
	    appointment.printMessage(zoneId);
	}
    }

    public class AppointmentServer {
	public class Appointment {
	    private String title;
	    private String content;
	    private ZonedDateTime dateTime = null;

	    public Appointment(String title, String content,
		    ZonedDateTime dateTime) {
		this.title = title;
		this.content = content;
		this.dateTime = dateTime;
	    }

	    public void printMessage(ZoneId zoneId) {
		ZonedDateTime zonedDateTime = dateTime
			.withZoneSameInstant(zoneId);
		DateTimeFormatter formatter = DateTimeFormatter
			.ofLocalizedDate(FormatStyle.FULL);
		System.out.println("Appointment Reminder: "
			+ formatter.format(zonedDateTime));
		System.out.println("Appointment Title: " + title);
		System.out.println(content);
		System.out.println();
	    }

	}

	Appointment appointment = null;

	List<Observer> observers = new ArrayList<>();

	public void setAppointment(String title, String content,
		ZonedDateTime appointment) {
	    this.appointment = new Appointment(title, content, appointment);

	}

	public void register(Observer observer) {
	    observers.add(observer);
	}

	public void sendReminder() {
	    observers.forEach(observer -> {
		System.out.println("Appointment Reminder for Observer: "
			+ observer.zoneId);
		observer.appointmentReminder(appointment);
	    });

	}

	public void start() throws InterruptedException {

	    Duration duration = Duration.ofMinutes(5);
	    ZonedDateTime appointmentReminderRange = appointment.dateTime
		    .minus(duration);
	    Callable<Void> timer = () -> {
		System.out.println("AppointmentServer: "
			+ Thread.currentThread().getName()
			+ " has started ...\n");

		while (true) {
		    ZonedDateTime now = ZonedDateTime.now(appointment.dateTime
			    .getZone());
		    if (now.isAfter(appointmentReminderRange)
			    && now.isBefore(appointment.dateTime)) {
			sendReminder();
			break;
		    } else {
			// System.out.println("Sleeping");
			Thread.sleep(60000); // sleeping for 60 seconds before
			// System.out.println("End Sleeping");
		    }

		}
		System.out.println("AppointmentServer: "
			+ Thread.currentThread().getName() + " has ended!!!");
		return null;
	    };

	    ExecutorService service = Executors.newCachedThreadPool();
	    service.submit(timer);
	    service.shutdown();
	}

    }

    public static void ch12Q11() {
	LocalTime departureTime = LocalTime.of(14, 00, 45);
	LocalTime arrivalTime = LocalTime.of(16, 40);
	String arrivalZone = "America/Los_Angeles";
	String departureZone = "Europe/Berlin";
	Duration duration = calcualteDuration(departureTime, departureZone,
		arrivalTime, arrivalZone);

	long totalSeconds = duration.getSeconds();
	long hours = totalSeconds / 3600;
	long minutes = (totalSeconds % 3600) / 60;
	long seconds = ((totalSeconds % 3600) % 60);

	System.out.println(totalSeconds);
	System.out.println(duration);
	System.out.println("Your flight will take " + hours + " hours "
		+ minutes + " minutes " + seconds + " seconds");
    }

    private static Duration calcualteDuration(LocalTime departureTime,
	    String departureZone, LocalTime arrivalTime, String arrivalZone) {

	LocalDate today = LocalDate.now();
	ZonedDateTime departure = ZonedDateTime.of(today, departureTime,
		ZoneId.of(departureZone));
	ZonedDateTime arrival = ZonedDateTime.of(today, arrivalTime,
		ZoneId.of(arrivalZone));

	Duration duration = Duration.between(departure, arrival);

	return duration;

    }

    public static void ch12Q10() {
	ZoneId departureZoneId = ZoneId.of("America/Los_Angeles");
	ZoneId destinationZoneId = ZoneId.of("Europe/Berlin");
	ZonedDateTime departure = ZonedDateTime.of(LocalDate.of(2013, 3, 31),
		LocalTime.of(2, 30), departureZoneId);
	Duration duration = Duration.ofMinutes(160);

	ZonedDateTime arrivalTime = departure.plus(duration);
	System.out.println("Arrivale Time based on Departure City: "
		+ arrivalTime);
	ZonedDateTime destinationTime = arrivalTime
		.withZoneSameInstant(destinationZoneId);
	System.out.println(ZonedDateTime.ofInstant(arrivalTime.toInstant(),
		destinationZoneId));
	System.out.println("Arrivale Time based on Destination City: "
		+ destinationTime);
    }

    public static void ch12Q9() {

	ZoneId.getAvailableZoneIds()
		.stream()
		.filter(zone -> {
		    ZoneOffset zoneOffset = ZonedDateTime.of(
			    LocalDateTime.now(), ZoneId.of(zone)).getOffset();

		    int offset = zoneOffset.getTotalSeconds();
		    if (offset % 3600 == 0) {
			return false;
		    }
		    return true;
		}).forEach(System.out::println);
    }

    public static void ch12Q8() {
	LocalDateTime today = LocalDateTime.now();
	ZoneId.getAvailableZoneIds()
		.stream()
		.forEach(
			zone -> {
			    ZonedDateTime zonedDateTime = ZonedDateTime.of(
				    today, ZoneId.of(zone));
			    System.out.println(zone + " "
				    + zonedDateTime.getOffset());
			});

    }

    public static void proxy() {
	IPlugin iramin = new IPlugin() {

	    @Override
	    public String getName() {

		return "Ramin";
	    }
	};

	Class<?>[] interfaces = IPlugin.class.getInterfaces();
	System.out.println(Arrays.toString(interfaces));
	Object object = Proxy.newProxyInstance(IPlugin.class.getClassLoader(),
		new Class[] { IPlugin.class }, (Object proxy, Method method,
			Object[] arguments) -> {
		    System.out.println("Hello from handler");
		    return "Ramin Dutt";
		});
	ClassLoader classLoader = Root.class.getClassLoader();
	URLClassLoader urlClassLoader = (URLClassLoader) (Root.class
		.getClassLoader());
	URL[] urls = urlClassLoader.getURLs();
	System.out.println(Arrays.toString(urls));
	System.out.println();
	IPlugin iramin2 = (IPlugin) object;
	System.out.println(iramin2.getName());

	System.out.println(String.class.getClassLoader());
	System.out.println(IPlugin.class.getClassLoader());
    }

    public static void ch12Q7() {

	LocalDateTime meeting1_start = LocalDateTime.of(2018, 6, 22, 10, 0);
	LocalDateTime meeting1_end = LocalDateTime.of(2018, 6, 22, 11, 0);
	TimeInterval meeting1 = new TimeInterval(meeting1_start, meeting1_end);

	LocalDateTime meeting2_start = LocalDateTime.of(2018, 6, 23, 10, 00);
	LocalDateTime meeting2_end = LocalDateTime.of(2018, 6, 23, 11, 00);
	TimeInterval meeting2 = new TimeInterval(meeting2_start, meeting2_end);

	System.out.println(meeting1.isConfict(meeting2));
    }

    private static void ch12Q6() {
	LocalDate start = LocalDate.of(1901, 1, 1);
	LocalDate end = LocalDate.of(2000, 12, 31);

	List<LocalDate> friday13 = new ArrayList<LocalDate>();
	LocalDate nextFriday = start;
	while (nextFriday.isBefore(end)) {
	    nextFriday = nextFriday.with(TemporalAdjusters
		    .next(DayOfWeek.FRIDAY));
	    if (nextFriday.getDayOfMonth() == 13) {
		friday13.add(nextFriday);
	    }
	}

	System.out.println(friday13.size());
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter
		.ofPattern("MM/dd/yyyy");
	friday13.forEach(d -> {
	    System.out.println(dateTimeFormatter.format(d));
	});

    }

    private static void ch12Q5() {
	LocalDate today = LocalDate.now();
	LocalDate bDay = LocalDate.of(1980, Month.JULY, 22);
	System.out.println(ChronoUnit.MONTHS.between(bDay, today) + "Months");
	System.out.println(ChronoUnit.WEEKS.between(bDay, today) + "weeks");
	System.out.println(ChronoUnit.DAYS.between(bDay, today) + "days");
    }

    private static void ch12Q4() {
	cal(4, 2025);
    }

    private static void cal(int month, int year) {
	int[][] calendar = new int[6][7];
	LocalDate date = LocalDate.of(year, month, 1);
	LocalDate firstDayOfNextMonth = date.with(TemporalAdjusters
		.firstDayOfNextMonth());

	int translation = date.getDayOfWeek().getValue() - 1;
	while (!date.equals(firstDayOfNextMonth)) {

	    int a = date.getDayOfMonth() + translation;
	    int i = -1;
	    if (a % 7 == 0) {
		i = a / 7 - 1;
	    } else {
		i = a / 7;
	    }

	    int j = date.getDayOfWeek().getValue() - 1;
	    calendar[i][j] = date.getDayOfMonth();
	    // System.out.println(date);
	    date = date.plusDays(1);
	}

	int x = 0;
	while (x < calendar.length) {
	    int y = 0;
	    while (y < calendar[x].length) {
		int day = calendar[x][y];
		if (day != 0) {
		    System.out.print(day);
		}
		System.out.print("\t");
		y++;
	    }
	    System.out.println();
	    x++;
	}
    }

    private static void ch12Q3() {

	LocalDate today = LocalDate.now();
	Predicate<LocalDate> predicate = date -> (date.getMonth() == Month.DECEMBER)
		&& date.getDayOfWeek() == DayOfWeek.MONDAY;

	TemporalAdjuster adjuster = next(predicate);
	LocalDate localDate = today.with(adjuster);
	System.out.println(localDate);
    }

    private static TemporalAdjuster next(Predicate<LocalDate> predicate) {

	TemporalAdjuster nextAdjuster = TemporalAdjusters
		.ofDateAdjuster(date -> {
		    LocalDate nextDay = null;
		    int i = 1;
		    boolean flag = true;
		    while (flag) {
			nextDay = date.plusDays(i);
			if (predicate.test(nextDay)) {
			    flag = false;
			}
			i++;
		    }

		    return nextDay;
		});

	return nextAdjuster;
    }

    public static void ch12Q2() {
	System.out.println(LocalDate.of(2002, 2, 29).plusYears(4));
    }

    public static void ch12q1(int year) {
	LocalDate programmersDay = LocalDate.ofYearDay(
		Year.of(year).getValue(), 256);
	System.out.println(programmersDay);

    }

    public static void swap() {
	Random random = new Random();
	int[] array = random.ints(0, 100).limit(10).toArray();
	System.out.println(Arrays.toString(array));

	int count = raminSelectionSort(array);
	System.out.println(Arrays.toString(array));
	System.out.println("Count = " + count);
    }

    private static int raminSelectionSort(int[] array) {
	// Sorting
	int i = 1;
	int count = 0;
	int size = array.length;
	while (i < size) {

	    if (array[i] < array[i - 1]) {
		int temp = array[i - 1];
		array[i - 1] = array[i];
		array[i] = temp;
		count++;
		int j = i - 1;
		while (j >= 1) {
		    if (array[j] < array[j - 1]) {
			temp = array[j];
			array[j] = array[j - 1];
			array[j - 1] = temp;
			j--;
			count++;
		    } else {
			j = -1;
		    }
		}

	    }
	    i++;
	}
	return count;
    }

    public static void ch11Q10() {
	Item item = new Item();
	resourceProcessor(item);
	System.out.println(item.url);
	System.out.println("***************************");
	System.out.println(item.url2);

	System.out.println("+++++++++++++++++++++++++++++");
	System.out.println(item.url);
    }

    public static void resourceProcessor(Object object) {

	Class<Resource> classResource = Resource.class;

	Field[] fields = object.getClass().getDeclaredFields();
	for (Field field : fields) {
	    boolean isPresent = field.isAnnotationPresent(classResource);
	    if (isPresent) {
		Resource resource = field.getAnnotation(classResource);

		try {
		    URL url = new URL(resource.url());
		    try (InputStream inputStream = url.openStream();
			    InputStreamReader inputStreamReader = new InputStreamReader(
				    inputStream);
			    BufferedReader bufferedReader = new BufferedReader(
				    inputStreamReader)) {
			String resourceContent = bufferedReader.lines()
				.collect(Collectors.joining("\n"));
			field.setAccessible(true);
			field.set(object, resourceContent); // Injection

		    } catch (IOException e) {
			e.printStackTrace();
		    } catch (IllegalArgumentException e) {
			e.printStackTrace();
		    } catch (IllegalAccessException e) {

			e.printStackTrace();
		    }

		} catch (MalformedURLException e) {
		    e.printStackTrace();
		}

	    }
	}

    }

    public static void ch11Q9B(Object object) throws Exception {
	AtomicInteger passed = new AtomicInteger();
	LongAdder failed = new LongAdder();
	LongAdder ignored = new LongAdder();

	Class<TestCaseEnigma> testCaseEnigmaAnnotation = TestCaseEnigma.class;
	Class<TestCaseEnigma.EningmaTestCases> enigmaTestCasesAnnotation = TestCaseEnigma.EningmaTestCases.class;

	Method[] methods = object.getClass().getDeclaredMethods();
	List<Callable<String>> tasks = Stream
		.of(methods)
		.parallel()
		.filter(method -> method
			.isAnnotationPresent(testCaseEnigmaAnnotation)
			|| method
				.isAnnotationPresent(enigmaTestCasesAnnotation))
		.flatMap(
			method -> {
			    List<Callable<String>> callableTests = new ArrayList<>();

			    TestCaseEnigma[] testCaseEnigmaAnnotations = method
				    .getAnnotationsByType(testCaseEnigmaAnnotation);
			    for (TestCaseEnigma testCaseEnigma : testCaseEnigmaAnnotations) {
				Callable<String> test = () -> {
				    String testResult = null;
				    if (!testCaseEnigma.enabled()) {
					testResult = testCaseEnigma.name()
						+ ": Ignored";
					ignored.increment();

				    } else {
					String[] params = testCaseEnigma
						.params();
					Type[] types = method
						.getGenericParameterTypes();
					if (params.length != types.length) {
					    throw new Exception(
						    "The annotation @TestCaseEnigma parameters does not match the paramters of the methode");
					}

					int length = params.length;
					Object[] parameters = new Object[length];
					int i = 0;
					while (i < length) {
					    parameters[i] = convertStringToObject(
						    params[i], types[i]);
					    i++;
					}

					Object result = method.invoke(object,
						parameters);
					String actual = result.toString();
					String expected = testCaseEnigma
						.expected();
					try {
					    assert (actual.equals(expected));
					    testResult = testCaseEnigma.name()
						    + ": Passed";
					    passed.incrementAndGet();
					} catch (AssertionError assertionError) {
					    testResult = testCaseEnigma.name()
						    + ": Failed";
					    failed.increment();
					}
				    }
				    return testResult;
				};
				callableTests.add(test);
			    }
			    return callableTests.stream();
			}).collect(Collectors.toList());

	ExecutorService executorService = Executors.newCachedThreadPool();
	List<Future<String>> results = executorService.invokeAll(tasks);
	results.forEach(testResult -> {
	    try {
		System.out.println(testResult.get());
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	});

	executorService.shutdown();
	System.out.println("Total: " + results.size() + ", Passed: "
		+ passed.get() + ", Failed: " + failed.sum() + ", Ignored: "
		+ ignored.sum());
    }

    // ch11Q9
    public static void ch11Q9(Object object) throws Exception {
	int total = 0;
	int passed = 0;
	int failed = 0;
	int ignored = 0;

	Class<TestCaseEnigma> testCaseEnigmaAnnotation = TestCaseEnigma.class;
	Class<TestCaseEnigma.EningmaTestCases> enigmaTestCasesAnnotation = TestCaseEnigma.EningmaTestCases.class;

	Method[] methods = object.getClass().getDeclaredMethods();

	for (Method method : methods) {
	    if (method.isAnnotationPresent(testCaseEnigmaAnnotation)
		    || method.isAnnotationPresent(enigmaTestCasesAnnotation)) {

		TestCaseEnigma[] testCaseEnigmaAnnotations = method
			.getAnnotationsByType(testCaseEnigmaAnnotation);
		for (TestCaseEnigma testCaseEnigma : testCaseEnigmaAnnotations) {

		    if (!testCaseEnigma.enabled()) {
			System.out.println(testCaseEnigma.name() + ": Ignored");
			ignored++;
			continue;
		    }
		    String[] params = testCaseEnigma.params();
		    Type[] types = method.getGenericParameterTypes();
		    if (params.length != types.length) {
			throw new Exception(
				"The annotation @TestCaseEnigma parameters does not match the paramters of the methode");
		    }

		    int length = params.length;
		    Object[] parameters = new Object[length];
		    int i = 0;
		    while (i < length) {
			parameters[i] = convertStringToObject(params[i],
				types[i]);
			i++;
		    }

		    Object result = method.invoke(object, parameters);
		    String actual = result.toString();
		    String expected = testCaseEnigma.expected();
		    try {
			assert (actual.equals(expected));
			System.out.println(testCaseEnigma.name() + ": Passed");
			passed++;
		    } catch (AssertionError assertionError) {
			System.out.println(testCaseEnigma.name() + ": Failed");
			failed++;
		    }

		    total++;
		}
	    }
	}

	System.out.println("Total: " + total + ", Passed: " + passed
		+ ", Failed: " + failed + ", Ignored: " + ignored);

    }

    private static Object convertStringToObject(String input, Type type) {
	Object result = null;

	switch (type.getTypeName()) {
	case "boolean":
	    result = Boolean.valueOf(input);
	    break;
	case "byte":
	    result = Byte.valueOf(input);
	    break;
	case "short":
	    result = Short.valueOf(input);
	    break;
	case "int":
	    result = Integer.valueOf(input);
	    break;
	case "long":
	    result = Long.valueOf(input);
	    break;
	case "float":
	    result = Float.valueOf(input);
	    break;
	case "double":
	    result = Double.valueOf(input);
	    break;
	case "char":
	    result = input.charAt(0);
	    break;
	case "java.lang.String":
	    result = input;
	    break;
	default:
	    try {
		result = Class.forName(input).newInstance();
	    } catch (InstantiationException e) {

		e.printStackTrace();
	    } catch (IllegalAccessException e) {

		e.printStackTrace();
	    } catch (ClassNotFoundException e) {

		e.printStackTrace();
	    }
	}
	return result;
    }

    @TestCaseEnigma(name = "Test 6", params = { "4", "9" }, expected = "true", enabled = true)
    @TestCaseEnigma(name = "Test 5", params = { "4", "4" }, expected = "true", enabled = true)
    @TestCaseEnigma(name = "Test 4", params = { "4", "9" }, expected = "false", enabled = true)
    public boolean isEqual(int x, int y) {
	return x == y ? true : false;
    }

    @TestCase(params = "45", expected = "264")
    @TestCase(params = "4", expected = "24")
    public static int factorial(int n) {
	int result = n;
	int i = n - 1;
	while (i >= 1) {

	    result = result * i;
	    i--;
	}
	return result;
    }

    @TestCaseEnigma(name = "Test 3", params = "4", expected = "245", enabled = false)
    @TestCaseEnigma(name = "Test 2", params = "4", expected = "245", enabled = true)
    @TestCaseEnigma(name = "Test 1", params = "4", expected = "24", enabled = true)
    @TestCase(params = "45", expected = "264")
    @TestCase(params = "4", expected = "24")
    public static int factorial_2(int n) {
	int result = n;
	int i = n - 1;
	while (i >= 1) {

	    result = result * i;
	    i--;
	}
	return result;
    }

    @Param(name = "array", description = "Array")
    @Param(name = "a", description = "Root description of A")
    @Return(description = "ReturnDescription_4")
    public static <A extends Employee> void f(ArrayList<A> array, A a) // same
								       // as
								       // public
								       // static
								       // <T
								       // extends
								       // Employee>
								       // void
								       // f(ArrayList<T>
								       // array)
    {
	A e = array.get(0); // OK
	// ArrayList<Employee> x = array; //compile error because ArrayList/
	// generics are not covariant
	array.add(a); // compile error
	// array.add(new Manager()); //compile error
    }

    @Todo(message = "Reminder message 7", description = "root class, Methode: binarySearch")
    public static void binarySearch() {
	Random random = new Random();
	int[] array = random.ints(100, 0, 100).toArray();
	Arrays.sort(array);
	System.out.println(Arrays.toString(array));
	int j = 0;
	while (j < array.length) {
	    System.out.println(j + "=" + array[j]);
	    j++;
	}

	int target = random.nextInt(100);
	System.out.println("target = " + target);
	int min = 0;
	int max = array.length - 1;
	boolean flag = true;
	int guess = -1;
	while (flag) {
	    guess = (min + max) / 2;
	    if (array[guess] == target) {
		flag = false;
	    } else {
		if (array[guess] < target) {
		    min = min + 1;
		} else {
		    max = max - 1;
		}

		if (min > max) {
		    flag = false;
		    guess = -1;
		}
	    }
	}

	System.out.println("Index = " + guess);

    }

    public static void ch11q3() {
	// You cannot have the constructor of an object calling itself again.
	// That will give a compiler error.
	Item item = new Item();
	Point north = new Point(50, 520);
	item.from.cyclic = north;
	Path path = Paths.get("/home/ramin/workspace/ch11/ch11Q2.ser");

	// Serializing an object
	DataOutputStreamCh11Q2 ch11q2 = new DataOutputStreamCh11Q2(path);
	ch11q2.writeObject(item);

	// Deserializing an object
	Item item2 = (Item) ch11q2.readObject();
	System.out.println(item2);

    }

    public static void ch11q2() {

	Item item = new Item();
	Path path = Paths.get("/home/ramin/workspace/ch11/ch11Q2.ser");

	// Serializing an object
	DataOutputStreamCh11Q2 ch11q2 = new DataOutputStreamCh11Q2(path);
	ch11q2.writeObject(item);

	// Deserializing an object
	Item item2 = (Item) ch11q2.readObject();
	System.out.println(item2);

    }

    public Object ch11Q1() throws CloneNotSupportedException {
	Class<Object> object = Object.class;
	Class<Cloneable2> annotationClass = Cloneable2.class;

	if (object.isAnnotationPresent(annotationClass)) {
	    Annotation annotation = (Annotation) object
		    .getAnnotation(annotationClass);
	    // Continue with cloning
	} else {
	    throw new CloneNotSupportedException();
	}

	return new Object();
    }

    private Object readResolve() throws ObjectStreamException {
	return null;
    }

    public static void ch10q25() {
	Supplier<PasswordAuthentication> getPassword = () -> {
	    System.out.println(Thread.currentThread().getName()
		    + ": getPassword Started ...");

	    String userName = null;
	    String password = null;

	    BufferedReader reader = new BufferedReader(new InputStreamReader(
		    System.in));
	    try {
		System.out.print("Enter your name: ");
		userName = reader.readLine();
		System.out.print("Enter your password: ");
		password = reader.readLine();

	    } catch (IOException e) {

		e.printStackTrace();

	    } finally {

	    }

	    PasswordAuthentication passwordAuthentication = new PasswordAuthentication(
		    userName, password.toCharArray());
	    return passwordAuthentication;
	};

	Predicate<PasswordAuthentication> predicate = (pa) -> {
	    System.out.println(Thread.currentThread().getName()
		    + ": predicate Started ...");
	    return new String(pa.getPassword()).equals("secret");
	};

	boolean repeat = false;
	while (!repeat) {
	    try {
		repeat = CompletableFuture
			.supplyAsync(getPassword)
			.thenApply(passwordAuth -> predicate.test(passwordAuth))
			.get();
		System.out.println("repeat=" + repeat);
	    } catch (InterruptedException e) {

		e.printStackTrace();
	    } catch (ExecutionException e) {

		e.printStackTrace();
	    }
	}

    }

    public static void ch10q24() {
	try {
	    URL url = new URL(
		    "file:///home/ramin/GitViewstore/RD_wiki/Java/Java.html");
	    Runnable task = () -> {
		BufferedReader in;
		try {
		    in = new BufferedReader(new InputStreamReader(
			    url.openStream()));
		    in.lines().forEach(line -> {
			Pattern pattern = Pattern.compile("<a.*/a>");
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
			    System.out.println(matcher.group());
			}

		    });
		} catch (Exception e) {

		    e.printStackTrace();
		}

	    };
	    CompletableFuture<Void> completableFuture = CompletableFuture
		    .runAsync(task);
	    ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);

	} catch (MalformedURLException e) {

	    e.printStackTrace();
	} catch (IOException e) {

	    e.printStackTrace();
	}
    }

    static Object lock = new Object();

    public static void ch10q23() {

	Callable<Void> task = () -> {
	    synchronized (lock) {

		// lock = new Object();
		System.out.println(Thread.currentThread().getName()
			+ ": Started");
		try {
		    Thread.sleep(3000);
		} catch (InterruptedException e) {

		    e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()
			+ ": End Sleeping");
	    }
	    return null;

	};

	ExecutorService executors = Executors.newCachedThreadPool();
	List<Callable<Void>> tasks = new ArrayList<>();
	tasks.add(task);
	tasks.add(task);
	try {
	    executors.invokeAll(tasks);
	} catch (InterruptedException e) {

	    e.printStackTrace();
	}

	executors.shutdown();
	System.out.println("Executors: shutdown");
    }

    public static void ch10q18() {
	Path directory = Paths.get("/home/ramin/GitViewstore");
	List<Path> files = new ArrayList<Path>();

	// Finding all files in a directory
	try (Stream<Path> stream = Files.list(directory);) {
	    List<Path> paths = stream.collect(Collectors.toList());

	    int index = 0;
	    while (index < paths.size()) {
		Path path = paths.get(index);
		File file = path.toFile();
		if (file.isDirectory()) {
		    List<Path> subDirectory = Files.list(path).collect(
			    Collectors.toList());
		    paths.addAll(subDirectory);
		} else {
		    files.add(path);
		}
		index++;
	    }
	} catch (IOException exception) {
	    exception.printStackTrace();
	}

	// Creating a CompletableFuture task for each File
	List<CompletableFuture<Void>> tasks = new ArrayList<>();

	LongAdder longAdder = new LongAdder();

	for (Path file : files) {
	    Runnable runnable = () -> {
		try (Stream<String> lines = Files.lines(file);) {

		    long count = lines.flatMap(line -> {
			return Stream.of(line.split("\\s"));
		    }).count();

		    longAdder.add(count);

		} catch (Exception exception) {
		    if (!(exception.getCause() instanceof MalformedInputException)) {
			exception.printStackTrace();
		    }
		}

	    };
	    CompletableFuture<Void> completableFuture = CompletableFuture
		    .runAsync(runnable);
	    tasks.add(completableFuture);
	}
	CompletableFuture<Void> barrier = CompletableFuture.allOf(tasks
		.toArray(new CompletableFuture[tasks.size()]));
	barrier.join();

	System.out.println("counterCh10Q18 = " + longAdder.sum());
    }

    static long counterCh10Q17 = 0;

    public static void ch10q17() {
	Path directory = Paths.get("/home/ramin/GitViewstore");
	List<Path> files = new ArrayList<Path>();

	// Finding all files in a directory
	try (Stream<Path> stream = Files.list(directory);) {
	    List<Path> paths = stream.collect(Collectors.toList());

	    int index = 0;
	    while (index < paths.size()) {
		Path path = paths.get(index);
		File file = path.toFile();
		if (file.isDirectory()) {
		    List<Path> subDirectory = Files.list(path).collect(
			    Collectors.toList());
		    paths.addAll(subDirectory);
		} else {
		    files.add(path);
		}
		index++;
	    }
	} catch (IOException exception) {
	    exception.printStackTrace();
	}

	// Creating a CompletableFuture task for each File
	List<CompletableFuture<Void>> tasks = new ArrayList<>();
	Object lock = new Object();
	for (Path file : files) {
	    Runnable runnable = () -> {
		try (Stream<String> lines = Files.lines(file);) {

		    long count = lines.flatMap(line -> {
			return Stream.of(line.split("\\s"));
		    }).count();
		    synchronized (lock) {

			counterCh10Q17 = counterCh10Q17 + count;
		    }
		} catch (Exception exception) {
		    if (!(exception.getCause() instanceof MalformedInputException)) {
			exception.printStackTrace();
		    }
		}

	    };
	    CompletableFuture<Void> completableFuture = CompletableFuture
		    .runAsync(runnable);
	    tasks.add(completableFuture);
	}
	CompletableFuture<Void> barrier = CompletableFuture.allOf(tasks
		.toArray(new CompletableFuture[tasks.size()]));
	barrier.join();

	System.out.println("counterCh10Q17 = " + counterCh10Q17);
    }

    static long counterCh10Q16 = 0;

    public static void ch10q16() {
	Path directory = Paths.get("/home/ramin/GitViewstore");
	List<Path> files = new ArrayList<Path>();

	// Finding all files in a directory
	try (Stream<Path> stream = Files.list(directory);) {
	    List<Path> paths = stream.collect(Collectors.toList());

	    int index = 0;
	    while (index < paths.size()) {
		Path path = paths.get(index);
		File file = path.toFile();
		if (file.isDirectory()) {
		    List<Path> subDirectory = Files.list(path).collect(
			    Collectors.toList());
		    paths.addAll(subDirectory);
		} else {
		    files.add(path);
		}
		index++;
	    }
	} catch (IOException exception) {
	    exception.printStackTrace();
	}

	// Creating a CompletableFuture task for each File
	List<CompletableFuture<Void>> tasks = new ArrayList<>();
	Object lock = new Object();
	for (Path file : files) {
	    Runnable runnable = () -> {
		try (Stream<String> lines = Files.lines(file);) {

		    long count = lines.flatMap(line -> {
			return Stream.of(line.split("\\s"));
		    }).count();
		    counterCh10Q16 = counterCh10Q16 + count;

		} catch (Exception exception) {
		    if (!(exception.getCause() instanceof MalformedInputException)) {
			exception.printStackTrace();
		    }
		}

	    };
	    CompletableFuture<Void> completableFuture = CompletableFuture
		    .runAsync(runnable);
	    tasks.add(completableFuture);
	}
	CompletableFuture<Void> barrier = CompletableFuture.allOf(tasks
		.toArray(new CompletableFuture[tasks.size()]));
	barrier.join();

	System.out.println("counterCh10Q16 = " + counterCh10Q16);
    }

    public static void ch10q15() {
	// Get all files
	Path directory = Paths.get("/home/ramin/GitViewstore");
	List<Path> files = new ArrayList<Path>();
	try {
	    List<Path> paths = Files.list(directory).collect(
		    Collectors.toCollection(LinkedList::new));
	    int index = 0;
	    while (index < paths.size()) {
		Path path = paths.get(index);
		File file = path.toFile();
		if (file.isDirectory()) {
		    List<Path> subDirectory = Files.list(path).collect(
			    Collectors.toCollection(LinkedList::new));
		    paths.addAll(subDirectory);

		} else {
		    files.add(path);
		}
		index++;

	    }
	} catch (IOException e) {

	    e.printStackTrace();
	}
	Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
	List<Callable<Void>> tasks = files
		.stream()
		.map(path -> {

		    Callable<Void> task = () -> {
			// System.out.println(Thread.currentThread().getName()
			// + ": Started ...");
			try (Stream<String> lines = Files.lines(path)
				.parallel();) {
			    Stream<String> words = lines.flatMap(line -> {
				return Stream.of(line.split("\\s"));
			    });
			    words.forEach(word -> {
				concurrentHashMap.merge(word, 1, (x, y) -> x
					+ y);
			    });
			} catch (Exception exception) {
			    if (!(exception.getCause() instanceof MalformedInputException)) {
				exception.printStackTrace();
			    }

			}
			/*
			 * System.out.println(Thread.currentThread().getName() +
			 * ": COMPLETED!!!");
			 */
			return null;
		    };
		    return task;
		}).collect(Collectors.toList());

	ExecutorService executorService = Executors.newCachedThreadPool();
	try {
	    executorService.invokeAll(tasks);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	// Sorting
	Comparator<Entry<String, Integer>> comparator = ((e1, e2) -> {
	    if (e1.getValue() < e2.getValue()) {
		return 1;
	    }

	    if (e1.getValue() == e2.getValue()) {
		return 0;
	    }

	    return -1;
	});

	List<Entry<String, Integer>> list = concurrentHashMap.entrySet()
		.parallelStream().sorted(comparator)
		.collect(Collectors.toList());

	// Printing only the 10 most used words
	list.subList(0, 10).forEach(
		entry -> {
		    System.out.println("(" + entry.getKey() + ", "
			    + entry.getValue() + ")");
		});

	executorService.shutdown();
	System.out.println("executorService has been shutdown successfully.");

    }

    public static void ch10q14() {
	// Get all files
	Path directory = Paths.get("/home/ramin/GitViewstore");
	List<Path> files = new ArrayList<Path>();
	try {
	    List<Path> paths = Files.list(directory).collect(
		    Collectors.toCollection(LinkedList::new));
	    int index = 0;
	    while (index < paths.size()) {
		Path path = paths.get(index);
		File file = path.toFile();
		if (file.isDirectory()) {
		    List<Path> subDirectory = Files.list(path).collect(
			    Collectors.toCollection(LinkedList::new));
		    paths.addAll(subDirectory);

		} else {
		    files.add(path);
		}
		index++;

	    }
	} catch (IOException e) {

	    e.printStackTrace();
	}
	Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
	List<Callable<Void>> tasks = files
		.stream()
		.map(path -> {

		    Callable<Void> task = () -> {
			System.out.println(Thread.currentThread().getName()
				+ ": Started ...");
			try (Stream<String> lines = Files.lines(path);) {
			    Stream<String> words = lines.flatMap(line -> {
				return Stream.of(line.split("\\s"));
			    });
			    words.forEach(word -> {
				concurrentHashMap.merge(word, 1, (x, y) -> x
					+ y);
			    });
			} catch (Exception exception) {
			    if (!(exception.getCause() instanceof MalformedInputException)) {
				exception.printStackTrace();
			    }

			}
			System.out.println(Thread.currentThread().getName()
				+ ": COMPLETED!!!");
			return null;
		    };
		    return task;
		}).collect(Collectors.toList());

	ExecutorService executorService = Executors.newCachedThreadPool();
	try {
	    executorService.invokeAll(tasks);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}

	// Sorting
	List<Entry<String, Integer>> list = new ArrayList<>(
		concurrentHashMap.entrySet());
	Comparator<Entry<String, Integer>> comparator = ((e1, e2) -> {
	    if (e1.getValue() < e2.getValue()) {
		return 1;
	    }

	    if (e1.getValue() == e2.getValue()) {
		return 0;
	    }

	    return -1;
	});
	Collections.sort(list, comparator);

	// Printing only the 10 most used words
	list.subList(0, 10).forEach(
		entry -> {
		    System.out.println("(" + entry.getKey() + ", "
			    + entry.getValue() + ")");
		});

	executorService.shutdown();
	System.out.println("executorService has been shutdown successfully.");

    }

    public static void ch10q13() {
	// Get all files
	Path directory = Paths.get("/home/ramin/GitViewstore");
	List<Path> files = new ArrayList<Path>();
	try {
	    List<Path> paths = Files.list(directory).collect(
		    Collectors.toCollection(LinkedList::new));
	    int index = 0;
	    while (index < paths.size()) {
		Path path = paths.get(index);
		File file = path.toFile();
		if (file.isDirectory()) {
		    List<Path> subDirectory = Files.list(path).collect(
			    Collectors.toCollection(LinkedList::new));
		    paths.addAll(subDirectory);

		} else {
		    files.add(path);
		}
		index++;

	    }
	} catch (IOException e) {

	    e.printStackTrace();
	}

	List<Callable<Map<String, Integer>>> tasks = files
		.stream()
		.map(path -> {

		    Callable<Map<String, Integer>> task = () -> {
			System.out.println(Thread.currentThread().getName()
				+ ": Started ...");
			Map<String, Integer> frequency = new HashMap();
			try (Stream<String> lines = Files.lines(path);) {
			    Stream<String> words = lines.flatMap(line -> {
				return Stream.of(line.split("\\s"));
			    });
			    words.forEach(word -> {
				frequency.merge(word, 1, (x, y) -> x + y);
			    });
			} catch (Exception exception) {
			    if (!(exception.getCause() instanceof MalformedInputException)) {
				exception.printStackTrace();
			    }

			}
			System.out.println(Thread.currentThread().getName()
				+ ": COMPLETED!!!");
			return frequency;
		    };
		    return task;
		}).collect(Collectors.toList());

	ExecutorService executorService = Executors.newCachedThreadPool();
	ExecutorCompletionService<Map<String, Integer>> ecs = new ExecutorCompletionService<>(
		executorService);
	for (Callable<Map<String, Integer>> task : tasks) {
	    ecs.submit(task);
	}

	Map<String, Integer> finalWordFrequency = new HashMap<>();
	int size = tasks.size();
	int i = 0;
	while (i < size) {
	    // Merging

	    try {
		Map<String, Integer> fileWordFrequency = ecs.take().get();
		fileWordFrequency.forEach((key, value) -> {
		    finalWordFrequency.merge(key, value, (x, y) -> x + y);
		});

	    } catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
	    }
	    i++;
	}

	// Sorting
	List<Entry<String, Integer>> list = new ArrayList<>(
		finalWordFrequency.entrySet());
	Comparator<Entry<String, Integer>> comparator = ((e1, e2) -> {
	    if (e1.getValue() < e2.getValue()) {
		return 1;
	    }

	    if (e1.getValue() == e2.getValue()) {
		return 0;
	    }

	    return -1;
	});
	Collections.sort(list, comparator);

	// Printing only the 10 most used words
	list.subList(0, 10).forEach(
		entry -> {
		    System.out.println("(" + entry.getKey() + ", "
			    + entry.getValue() + ")");
		});

	executorService.shutdown();
	System.out.println("executorService has been shutdown successfully.");

    }

    public static void ch10q12() {
	// Get all files
	Path directory = Paths.get("/home/ramin/GitViewstore");
	List<Path> files = new ArrayList<Path>();
	try {
	    List<Path> paths = Files.list(directory).collect(
		    Collectors.toCollection(LinkedList::new));
	    int index = 0;
	    while (index < paths.size()) {
		Path path = paths.get(index);
		File file = path.toFile();
		if (file.isDirectory()) {
		    List<Path> subDirectory = Files.list(path).collect(
			    Collectors.toCollection(LinkedList::new));
		    paths.addAll(subDirectory);

		} else {
		    files.add(path);
		}
		index++;

	    }
	} catch (IOException e) {

	    e.printStackTrace();
	}

	List<Callable<Map<String, Integer>>> tasks = files
		.stream()
		.map(path -> {

		    Callable<Map<String, Integer>> task = () -> {
			System.out.println(Thread.currentThread().getName()
				+ ": Started ...");
			Map<String, Integer> frequency = new HashMap();
			try (Stream<String> lines = Files.lines(path);) {
			    Stream<String> words = lines.flatMap(line -> {
				return Stream.of(line.split("\\s"));
			    });
			    words.forEach(word -> {
				frequency.merge(word, 1, (x, y) -> x + y);
			    });
			} catch (Exception exception) {
			    if (!(exception.getCause() instanceof MalformedInputException)) {
				exception.printStackTrace();
			    }

			}
			System.out.println(Thread.currentThread().getName()
				+ ": COMPLETED!!!");
			return frequency;
		    };
		    return task;
		}).collect(Collectors.toList());

	ExecutorService executorService = Executors.newCachedThreadPool();
	try {
	    List<Future<Map<String, Integer>>> futures = executorService
		    .invokeAll(tasks);
	    // Merging
	    Map<String, Integer> finalWordFrequency = new HashMap<>();
	    for (Future<Map<String, Integer>> future : futures) {
		Map<String, Integer> fileWordFrequency = future.get();
		fileWordFrequency.forEach((key, value) -> {
		    finalWordFrequency.merge(key, value, (x, y) -> x + y);
		});
	    }

	    // Sorting
	    List<Entry<String, Integer>> list = new ArrayList<>(
		    finalWordFrequency.entrySet());
	    Comparator<Entry<String, Integer>> comparator = ((e1, e2) -> {
		if (e1.getValue() < e2.getValue()) {
		    return 1;
		}

		if (e1.getValue() == e2.getValue()) {
		    return 0;
		}

		return -1;
	    });
	    Collections.sort(list, comparator);

	    // Printing only the 10 most used words
	    list.subList(0, 10).forEach(
		    entry -> {
			System.out.println("(" + entry.getKey() + ", "
				+ entry.getValue() + ")");
		    });

	} catch (InterruptedException e) {

	    e.printStackTrace();
	} catch (ExecutionException e) {

	    e.printStackTrace();
	}

	executorService.shutdown();
	System.out.println("executorService has been shutdown successfully.");

    }

    private static StringBuilder getDummyFileName() {
	Random generator = new Random();
	StringBuilder builder = new StringBuilder();
	int size = generator.nextInt(10) + 4;
	int j = 0;
	while (j < size) {
	    char letter = (char) (generator.nextInt(25) + 97);
	    builder.append(letter);
	    j++;
	}
	return builder;
    }

    public static void ch10q11() {

	BlockingQueue<Path> blockingQueue = new LinkedBlockingQueue<>(1000);
	BlockingQueue<Map<String, Integer>> blockingQueue2 = new LinkedBlockingQueue<>();
	Path directory = Paths.get("/home/ramin/GitViewstore");
	// Path directory = Paths.get("/home/ramin/workspace/ch10");
	String dummyFile = getDummyFileName().toString();

	Callable<Void> producerTask = getProducerCh10Q10(blockingQueue,
		dummyFile, directory);

	Callable<Void> consumerTask = getConsumerTaskCh10Q11(blockingQueue,
		blockingQueue2, dummyFile);

	Callable<Void> getTenMostFrequentlyUsedWords = () -> {
	    System.out.println(Thread.currentThread().getName()
		    + ": MOST_FREQ_TASK Started ...");
	    Map<String, Integer> result = new HashMap<>();

	    while (true) {

		// System.out.println(Thread.currentThread().getName() +
		// ": MOST_FREQ_TASK start taking");
		Map<String, Integer> wordFrequenciesMap = blockingQueue2.take();
		// System.out.println(Thread.currentThread().getName() +
		// ": MOST_FREQ_TASK end taking");
		if (wordFrequenciesMap.containsKey(dummyFile)) {
		    System.out.println(wordFrequenciesMap);
		    System.out.println(Thread.currentThread().getName()
			    + ": MOST_FREQ_TASK Found DummyFile (" + dummyFile
			    + ")");

		    // Compute the 10 most common words
		    Comparator<Entry<String, Integer>> comparator = (x, y) -> {
			if (x.getValue() > y.getValue()) {
			    return -1;
			}
			if (x.getValue() == y.getValue()) {
			    return 0;
			}
			return 1;
		    };
		    result.entrySet()
			    .stream()
			    .sorted(comparator)
			    .limit(10)
			    .forEach(
				    e -> {
					System.out.println("(" + e.getKey()
						+ ", " + e.getValue());
				    });

		    /*
		     * result.entrySet() .stream() .sorted(comparator)
		     * .limit(10) .collect( Collectors .<Entry<String, Integer>,
		     * String, Integer, LinkedHashMap<String, Integer>> toMap(
		     * Entry::getKey, e -> e.getValue(), (x, y) -> x,
		     * LinkedHashMap::new)) .forEach((k, v) -> {
		     * System.out.println("(" + k + ", " + v); });
		     */

		    break;
		} else {
		    Iterator<Entry<String, Integer>> it = wordFrequenciesMap
			    .entrySet().iterator();
		    while (it.hasNext()) {

			Entry<String, Integer> entry = it.next();
			result.merge(entry.getKey(), entry.getValue(),
				(x, y) -> x + y);
		    }

		}
	    }
	    System.out.println(Thread.currentThread().getName()
		    + ": MOST_FREQ_TASK COMPLETED");
	    return null;
	};

	// Producer Thread
	ExecutorService executorService = Executors.newCachedThreadPool();
	executorService.submit(producerTask);

	// Consumer Thread
	int logicalCore = Runtime.getRuntime().availableProcessors();
	List<Future<Void>> consumers = new ArrayList<>();
	int i = 0;
	while (i < logicalCore) {
	    Future<Void> future = executorService.submit(consumerTask);
	    consumers.add(future);
	    i++;
	}

	Future<Void> mostUsedWords = executorService
		.submit(getTenMostFrequentlyUsedWords);

	// waiting for consumers to complete
	for (Future<Void> consumer : consumers) {

	    try {
		consumer.get();
	    } catch (InterruptedException e) {

		e.printStackTrace();
	    } catch (ExecutionException e) {

		e.printStackTrace();
	    }
	}

	// Adding The dummy Map to notify completion of consumers
	Map<String, Integer> dummyMap = new HashMap<>();
	dummyMap.put(dummyFile, null);
	System.out.println(Thread.currentThread().getName()
		+ ": Added dummy File to blockingQueue2");
	blockingQueue2.add(dummyMap);

	// The adder Thread

	try {
	    mostUsedWords.get();
	} catch (InterruptedException | ExecutionException e1) {

	    e1.printStackTrace();
	}

	System.out.println("blockingQueue2: " + blockingQueue2.size());
	// blockingQueue2.forEach(m -> m.keySet());
	System.out.println("Shutting Executors");
	try {
	    executorService.shutdown();
	    if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
		System.out.println("shutting Down Now");
		executorService.shutdownNow();
		System.out.println("Pool shutdown");
	    } else {
		System.out.println("Pool shutdown");
	    }

	} catch (InterruptedException e) {

	    e.printStackTrace();
	}

    }

    private static Callable<Void> getConsumerTaskCh10Q11(
	    BlockingQueue<Path> blockingQueue,
	    BlockingQueue<Map<String, Integer>> blockingQueue2, String dummyFile) {

	// Consumer
	AtomicBoolean finished = new AtomicBoolean(true);

	Callable<Void> consumerTask = () -> {
	    System.out.println(Thread.currentThread().getName()
		    + ": CONSUMER Started ...");

	    while (finished.get()) {

		Path path = null;
		// Handling the exit of threads
		synchronized (finished) {

		    if (finished.get()) {

			path = blockingQueue.take();

			File file = path.toFile();
			if (file.getName().equals(dummyFile)) {
			    finished.set(false);

			    System.out.println(Thread.currentThread().getName()
				    + ": CONSUMER found the dummy file ("
				    + dummyFile + ") and is exiting now");

			    break; // This thread has found the dummy file and
				   // should not do any processing and exit and
				   // mark itself as completed
			}

		    } else {
			// the dummy file has been found by another thread and
			// hence this thread should exit; marked as completed

			System.out.println(Thread.currentThread().getName()
				+ ": CONSUMER exiting  because dummy file ("
				+ dummyFile
				+ " ) has been found by another thread");

			break;
		    }
		}

		try (Stream<String> lines = Files.lines(path);) {
		    Map<String, Integer> wordFrequency = new HashMap<>();
		    String[] words = lines.flatMap(
			    line -> Stream.of(line.split("\\s"))).toArray(
			    size -> new String[size]);
		    for (String w : words) {
			wordFrequency.merge(w, 1, (x, y) -> x + y);
		    }
		    /*
		     * System.out.println(Thread.currentThread().getName() +
		     * ": Path = " + path);
		     */
		    blockingQueue2.put(wordFrequency);

		} catch (Exception exception) {
		    // Expected Error due to different file types

		    if (!(exception.getCause() instanceof MalformedInputException)) {
			exception.printStackTrace();
		    }

		}

	    }

	    System.out.println(Thread.currentThread().getName()
		    + ": CONSUMER COMPLETED!!!");
	    return null;
	};
	return consumerTask;
    }

    private static void ch10q10() {
	BlockingQueue<Path> blockingQueue = new LinkedBlockingQueue(1000);
	Path directory = Paths.get("/home/ramin/GitViewstore");
	String dummyFile = getDummyFileName().toString();
	String word = "git";

	Callable<Void> producerTask = getProducerCh10Q10(blockingQueue,
		dummyFile, directory);

	Callable<Void> consumerTask = getConsumerTaskch10Q10(blockingQueue,
		dummyFile, word);

	// Producer Thread
	ExecutorService executorService = Executors.newCachedThreadPool();
	executorService.submit(producerTask);

	// Consumer Thread
	int logicalCore = Runtime.getRuntime().availableProcessors();
	List<Future<Void>> consumers = new ArrayList<Future<Void>>();
	int i = 0;
	while (i < logicalCore) {
	    Future<Void> future = executorService.submit(consumerTask);
	    consumers.add(future);
	    i++;
	}

	try {
	    executorService.shutdown();
	    if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
		System.out.println("shutting Down Now");
		executorService.shutdownNow();
		System.out.println("Pool shutdown");
	    } else {
		System.out.println("Pool shutdown");
	    }

	} catch (InterruptedException e) {
	}

    }

    private static Callable<Void> getProducerCh10Q10(
	    BlockingQueue<Path> blockingQueue, String dummyFile, Path directory) {
	Callable<Void> producerTask = () -> {
	    System.out.println(Thread.currentThread().getName()
		    + ": PRODUCER Started ...");
	    try (Stream<Path> stream = Files.list(directory);) {
		List<Path> paths = stream.collect(Collectors.toList());

		int i = 0;
		while (i < paths.size()) {
		    Path path = paths.get(i);
		    if (path.toFile().isDirectory()) {
			List<Path> subDirectoryPath = Files.list(path).collect(
				Collectors.toList());
			paths.addAll(subDirectoryPath);

		    } else {
			// System.out.println(Thread.currentThread().getName() +
			// "Producer Putting = " + path);
			blockingQueue.put(path);

		    }
		    i++;
		}
		System.out.println(Thread.currentThread().getName()
			+ ": PRODUCER adding dummyFile (" + dummyFile
			+ ") to Queue");
		blockingQueue.put(Paths.get(dummyFile));

	    } catch (Exception exception) {
		exception.printStackTrace();
	    }
	    System.out.println(Thread.currentThread().getName()
		    + ": PRODUCER has COMPLETED!!!");
	    return null;
	};
	return producerTask;
    }

    private static Callable<Void> getConsumerTaskch10Q10(
	    BlockingQueue<Path> blockingQueue, String dummyFile, String word) {
	// Consumer
	AtomicBoolean finished = new AtomicBoolean(true);
	Callable<Void> consumerTask = () -> {
	    System.out.println(Thread.currentThread().getName()
		    + ": CONSUMER Started ...");
	    while (finished.get()) {
		Path path = null;

		synchronized (finished) {
		    if (finished.get()) {
			path = blockingQueue.take();
			File file = path.toFile();
			if (file.getName().equals(dummyFile)) {
			    finished.set(false);
			    System.out.println(Thread.currentThread().getName()
				    + ": CONSUMER found the dummy file ("
				    + dummyFile + ") and is exiting now");
			    break;
			}

		    } else {
			System.out.println(Thread.currentThread().getName()
				+ ": CONSUMER exiting  because dummy file ("
				+ dummyFile
				+ ") has been found by another thread");
			break;
		    }

		}

		try (Stream<String> lines = Files.lines(path);) {
		    boolean found = lines.anyMatch(s -> s.contains(word));
		    if (found) {
			System.out.println(Thread.currentThread().getName()
				+ ": CONSUMER Match Found = " + finished.get()
				+ " " + path);
		    }

		} catch (Exception exception) {
		    // Expected Error due to different file types
		    if (!(exception.getCause() instanceof MalformedInputException)) {
			exception.printStackTrace();
		    }

		}
	    }
	    System.out.println(Thread.currentThread().getName()
		    + ": CONSUMER COMPLETED!!!");
	    return null;
	};
	return consumerTask;
    }

    /**
     * Find all files in directories and sub directories via stream
     */
    @Fork(value = 1, warmups = 2)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public static void ch10q10a() {
	Path directory = Paths.get("/home/ramin/GitViewstore");

	List<Path> paths = null;
	;
	try {
	    paths = Files.list(directory).collect(Collectors.toList());
	} catch (IOException e) {

	    e.printStackTrace();
	}

	AtomicBoolean flag = new AtomicBoolean(true);
	while (flag.get()) {
	    flag.set(false);

	    // Using parallel stream is faster
	    paths = paths.stream().flatMap(path -> {
		File file = path.toFile();
		Stream<Path> result = null;
		if (!file.isDirectory()) {
		    result = Stream.<Path> of(path);
		} else {

		    try {
			result = Files.list(path);
		    } catch (IOException exception) {
			exception.printStackTrace();
		    }
		}
		return result;
	    }).peek(p -> {
		if (p.toFile().isDirectory()) {
		    flag.set(true);
		}
	    }).collect(Collectors.toList());

	}

	paths.forEach(System.out::println);
	System.out.println("size = " + paths.size());

    }

    /**
     * Find all files in directories and sub directories via collection
     */
    @Fork(value = 1, warmups = 2)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public static void ch10q10b() {
	Path directory = Paths.get("/home/ramin/GitViewstore");

	try (Stream<Path> stream = Files.list(directory);) {
	    // List<Path> paths = stream.collect(Collectors.toList());
	    List<Path> paths = stream.collect(Collectors
		    .toCollection(() -> new LinkedList<Path>()));

	    int i = 0;
	    while (i < paths.size()) {
		Path path = paths.get(i);
		if (path.toFile().isDirectory()) {
		    paths.remove(i);
		    List<Path> subDirectoryPath = Files
			    .list(path)
			    .collect(
				    Collectors
					    .toCollection(() -> new LinkedList<Path>()));
		    // List<Path> subDirectoryPath =
		    // Files.list(path).collect(Collectors.toList());
		    paths.addAll(subDirectoryPath);

		} else {
		    i++;
		}
	    }
	    paths.forEach(System.out::println);
	    System.out.println("size = " + paths.size());

	} catch (IOException exception) {
	    exception.printStackTrace();
	}

    }

    public static void ch10q9() {
	List<Integer> vector = new Vector<Integer>();
	LongAccumulator max = new LongAccumulator((x, y) -> (x >= y) ? x : y,
		-1);

	LongAccumulator min = new LongAccumulator((x, y) -> (x == -1) ? y
		: (x < y) ? x : y, -1);

	LongAccumulator accumulator = min;
	Supplier<Callable<Void>> supplier = () -> {
	    Callable<Void> task = () -> {
		int number = new Random().nextInt(100);
		accumulator.accumulate(number);
		vector.add(number);
		return null;
	    };
	    return task;

	};
	List<Callable<Void>> tasks = Stream.generate(supplier).limit(1000)
		.collect(Collectors.toList());
	ExecutorService executorService = Executors.newCachedThreadPool();
	try {
	    List<Future<Void>> futures = executorService.invokeAll(tasks);
	    System.out.println(vector);
	    System.out.println(accumulator.get());
	} catch (InterruptedException e) {

	    e.printStackTrace();
	}
	executorService.shutdown();

    }

    private static void ch10q8a() {
	AtomicLong atomicLong = new AtomicLong();

	ExecutorService executorService = Executors.newCachedThreadPool();
	List<Callable<Void>> tasks = new ArrayList<>();
	int i = 0;
	while (i < 1000) {
	    Callable<Void> task = () -> {
		int j = 0;
		while (j < 100000) {
		    atomicLong.incrementAndGet();
		    j++;
		}
		return null;
	    };
	    tasks.add(task);
	    i++;
	}

	try {
	    long start = System.currentTimeMillis();
	    executorService.invokeAll(tasks);
	    long end = System.currentTimeMillis();

	    System.out.println("atomicLong time: "
		    + Math.subtractExact(end, start) + "ms + atomicLong="
		    + atomicLong.get());
	    executorService.shutdown();

	} catch (InterruptedException e) {

	    e.printStackTrace();
	}

    }

    public static void ch10q8b() {
	LongAdder longAdder = new LongAdder();
	List<Callable<Void>> tasks = IntStream.generate(() -> 1).limit(1000)
		.boxed().map(index -> {
		    Callable<Void> task = () -> {
			int j = 0;
			while (j < 100000) {
			    longAdder.increment();
			    j++;
			}
			return null;
		    };
		    return task;
		}).collect(Collectors.toList());

	ExecutorService executorService = Executors.newCachedThreadPool();

	try {
	    long start = System.currentTimeMillis();
	    executorService.invokeAll(tasks);
	    long end = System.currentTimeMillis();
	    System.out.println("longAdder time: "
		    + Math.subtractExact(end, start) + " ms + longAdder="
		    + longAdder.sum());
	    executorService.shutdown();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    public static void ch10q7() {
	ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<>();
	int i = 0;
	while (i < 10) {
	    Random generator = new Random();
	    String key = generateRandomWord(1 + generator.nextInt(10));
	    long value = generator.nextInt(100);
	    concurrentHashMap.put(key, value);
	    i++;
	}
	System.out.println(concurrentHashMap);
	BiFunction<Entry<String, Long>, Entry<String, Long>, Entry<String, Long>> reducer = (
		e1, e2) -> {
	    return e1.getValue() > e2.getValue() ? e1 : e2;
	};
	Entry<String, Long> result = concurrentHashMap
		.reduceEntries(2, reducer);
	System.out.println(result);

    }

    private static String generateRandomWord(int length) {
	Random genRandom = new Random();
	StringBuilder builder = new StringBuilder();
	int i = 0;
	while (i < length) {
	    char letter = (char) (97 + genRandom.nextInt(26));
	    builder.append(letter);
	    i++;
	}
	return builder.toString();
    }

    public static void ch10q6() {
	String directory = "/home/ramin/workspace/ch10";
	Path directoryPath = Paths.get(directory);
	ConcurrentHashMap<String, Set<Path>> concurrentHashMap = new ConcurrentHashMap<>();

	try (Stream<Path> files = Files.list(directoryPath);) {
	    // Creating a List of tasks
	    List<CompletableFuture<Void>> tasks = files.map(
		    p -> {
			CompletableFuture<Void> task = CompletableFuture
				.runAsync(getTask(p, concurrentHashMap));
			return task;
		    }).collect(Collectors.toList());

	    // creating a barrier and wait untill all concurrent tasks have been
	    // completed
	    CompletableFuture<Void> barrier = CompletableFuture.allOf(tasks
		    .toArray(new CompletableFuture[tasks.size()]));
	    barrier.join(); // This is important

	    // Printing it out result

	    concurrentHashMap.forEach((k, v) -> {
		System.out.println("Key: (" + k + ") Value= " + v);
	    });

	} catch (IOException e) {

	    e.printStackTrace();
	}
    }

    private static Runnable getTask(Path p, ConcurrentMap<String, Set<Path>> map) {
	Runnable task = () -> {
	    try (Stream<String> lines = Files.lines(p);) {
		Stream<String> words = lines.flatMap(w -> {
		    return Arrays.stream((w.split("[\\s]")));
		});

		words.forEach(w -> {
		    map.computeIfPresent(w, (k, v) -> {
			v.add(p);
			return v;
		    });
		    map.computeIfAbsent(w, k -> new HashSet<>()).add(p);
		});
	    } catch (Exception exception) {
		exception.printStackTrace();
	    }
	};
	return task;
    }

    public static void ch10q5() {
	String directory = "/home/ramin/workspace/ch10";
	Path directoryPath = Paths.get(directory);

	ConcurrentHashMap<String, Set<Path>> concurrentHashMap = new ConcurrentHashMap<>();
	// Getting the list of all files
	try (Stream<Path> files = Files.list(directoryPath);) {
	    List<Callable<Void>> tasks = files.map(
		    p -> {
			Callable<Void> task = () -> {

			    // Making a stream of all words in the document
			    Stream<String> words = Files.lines(p).flatMap(
				    line -> {
					String[] wordsArray = line
						.split("[\\s]");
					Stream<String> wordsStream = Stream
						.of(wordsArray);
					return wordsStream;
				    });

			    // Modifying the shared object: concurrentHashMap
			    words.forEach(w -> {
				Set<Path> set = new HashSet();
				set.add(p);
				concurrentHashMap.merge(w, set, (
					Set<Path> existingValue,
					Set<Path> newValue) -> {
				    if (existingValue == null) {
					return newValue;
				    } else {
					existingValue.addAll(newValue);
					return existingValue;
				    }
				});
			    });

			    return null;
			};
			return task;
		    }).collect(Collectors.toList());

	    ExecutorService executorService = Executors.newCachedThreadPool();
	    try {
		List<Future<Void>> results = executorService.invokeAll(tasks);
		Iterator<Entry<String, Set<Path>>> iterator = concurrentHashMap
			.entrySet().iterator();
		while (iterator.hasNext()) {
		    Entry<String, Set<Path>> entry = iterator.next();
		    String key = entry.getKey();
		    Set paths = entry.getValue();
		    System.out.println("key: " + key + ": " + paths.toString());
		}

		System.out.println("*******");
		System.out.println(concurrentHashMap.get("git"));
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    public static void ch10q3g() {
	String word = "git";
	String directory = "/home/ramin/workspace/ch10";
	Path directoryPath = Paths.get(directory);
	// Create a stream of callables
	try (Stream<Path> files = Files.list(directoryPath);) {
	    Stream<Callable<Path>> callables = files.map((Path path) -> {
		Callable<Path> callable = () -> {
		    try (Stream<String> content = Files.lines(path);) {
			boolean isFound = content.anyMatch((String w) -> w
				.contains(word));
			if (isFound) {
			    return path;
			} else {
			    throw new ExecutionException(
				    "Something went wrong", null);
			}
		    } catch (IOException exception) {
			exception.printStackTrace();
		    }
		    return null;
		};
		return callable;
	    });

	    List<Callable<Path>> tasks = callables.collect(Collectors.toList());
	    ExecutorService executorService = Executors.newCachedThreadPool();
	    tasks.forEach((Callable<Path> task) -> {
		Future<Path> future = executorService.submit(task);
		try {
		    System.out.println(future.get());
		} catch (Exception e) {
		    e.printStackTrace();
		}

	    });

	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    /**
     * Finding the first document containing the searched word using
     * completableFuture: using filter and findAny with streams
     */
    public static void ch10q3f() {
	String word = "git";
	String directory = "/home/ramin/workspace/ch10";
	Path directoryPath = Paths.get(directory);
	// Create a stream of callables
	try (Stream<Path> files = Files.list(directoryPath);) {
	    Stream<Callable<Path>> callables = files.map((Path path) -> {
		Callable<Path> callable = () -> {
		    try (Stream<String> content = Files.lines(path);) {
			boolean isFound = content.anyMatch((String w) -> w
				.contains(word));
			if (isFound) {
			    return path;
			} else {
			    throw new ExecutionException(null);
			}
		    } catch (IOException exception) {
			exception.printStackTrace();
		    }
		    return null;
		};
		return callable;
	    });

	    List<Callable<Path>> tasks = callables.collect(Collectors.toList());
	    ExecutorService executorService = Executors.newCachedThreadPool();
	    try {
		Path p = executorService.invokeAny(tasks);
		System.out.println("Result = " + p);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    } catch (ExecutionException e) {
		e.printStackTrace();
	    }

	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    /**
     * Finding the first document containing the searched word using
     * completableFuture: using filter and findAny with streams
     */
    public static void ch10q3e() {
	String word = "git";
	String directory = "/home/ramin/workspace/ch10";
	Path directoryPath = Paths.get(directory);

	try (Stream<Path> files = Files.list(directoryPath);) {
	    Stream<Path> searchResult = files
		    .filter((Path path) -> {
			CompletableFuture<Optional<Path>> completableFuture = CompletableFuture.supplyAsync(() -> {
			    Optional<Path> optional = Optional.empty();
			    try (Stream<String> content = Files.lines(path)) {
				boolean isFound = content.parallel().anyMatch(
					w -> w.contains(word));
				if (isFound) {
				    optional = Optional.of(path);
				}

			    } catch (IOException ioException) {
				ioException.printStackTrace();
			    }
			    return optional;
			});

			try {
			    Optional<Path> result = completableFuture.get();
			    return result.isPresent() ? true : false;
			} catch (Exception e) {

			    e.printStackTrace();
			}

			return false;
		    });

	    // Printing result: all documents containing the word
	    long start = System.currentTimeMillis();
	    // searchResult.forEach(System.out::println);

	    // Finding the first document only
	    System.out.println(searchResult.findAny().get());
	    long end = System.currentTimeMillis();

	    System.out
		    .println("Time: " + Math.subtractExact(end, start) + "ms");
	} catch (IOException ioException) {
	    ioException.printStackTrace();
	}
    }

    /**
     * This api finds the documents containing the word but it searches through
     * all the document. It does not cancel the other threads once the first
     * document containing the word has been found. Hence, it finds all
     * documents containing the word
     */
    public static void ch10q3d() {
	String word = "git";
	String stringPath = "/home/ramin/workspace/ch10";
	Path path = Paths.get(stringPath);

	try (Stream<Path> files = Files.list(path)) {

	    List<CompletableFuture<Optional<Path>>> searchResult = files
		    .map((Path p) -> {
			CompletableFuture<Optional<Path>> completableFutureOptional = CompletableFuture
				.supplyAsync(() -> {
				    boolean result = false;
				    try {
					result = Files.lines(p).anyMatch(
						(String s) -> s.contains(word));
				    } catch (IOException exception) {
					exception.printStackTrace();
				    }
				    Optional<Path> optional = Optional.empty();
				    if (result) {
					optional = Optional.of(p);
				    }
				    return optional;
				});

			return completableFutureOptional;
		    }).collect(Collectors.toList());

	    searchResult.forEach(completableFuture -> {

		try {

		    if (!completableFuture.isCompletedExceptionally()) {

			Optional<Path> opt = completableFuture.get();

			if (opt.isPresent()) {
			    System.out.println(opt.get()
				    + " : "
				    + completableFuture
					    .isCompletedExceptionally());
			}

		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}

	    });

	} catch (Exception exception) {
	    exception.printStackTrace();
	}

    }

    public static void ch10q3c() {
	String word = "git";
	String p = "/home/ramin/workspace/ch10";
	Path p2 = Paths.get(p);

	try {
	    Stream<CompletableFuture<String>> stream = Files
		    .list(p2)
		    .map(path -> {
			CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			    String result = "NOT FOUND";
			    try (Stream<String> content = Files.lines(path)) {
				boolean found = content.parallel().anyMatch(
					s -> s.contains(word));
				if (found) {
				    result = path.toString();
				} else {
				    throw new Exception();
				}

			    } catch (Exception e) {

				e.printStackTrace();
			    }

			    return result;
			});
			return future;
		    });

	    CompletableFuture<String>[] completableFutures = stream
		    .toArray(CompletableFuture[]::new);
	    CompletableFuture<Object> result = CompletableFuture
		    .anyOf(completableFutures);
	    System.out.println(result.get());
	} catch (Exception exception) {
	    exception.printStackTrace();
	}

    }

    public static void ch10q3b() {
	String word = "git";
	String p = "/home/ramin/workspace/ch10";
	Path p2 = Paths.get(p);

	try {
	    Optional<Path> result = Files
		    .list(p2)
		    .filter(path -> {
			boolean isFound = false;
			try (Stream<String> lines = Files.lines(path)) {
			    isFound = lines.parallel().anyMatch(
				    line -> line.contains(word));
			} catch (Exception exception) {
			    exception.printStackTrace();

			}
			return isFound;
		    }).findAny();

	    // stream.forEach(System.out::println);
	    System.out.println(result.get());

	} catch (Exception exception) {
	    exception.printStackTrace();
	}
    }

    public static void ch10q3a() {
	String word = "git";
	String p = "/home/ramin/workspace/ch10";
	Path p2 = Paths.get(p);

	try {
	    Stream<CompletableFuture<String>> stream = Files
		    .list(p2)
		    .map(path -> {
			CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			    String result = "NOT FOUND";
			    try (Stream<String> content = Files.lines(path)) {
				boolean found = content.parallel().anyMatch(
					s -> s.contains(word));
				if (found) {
				    result = path.toString();
				}

			    } catch (Exception e) {

				e.printStackTrace();
			    }
			    return result;
			});
			return future;
		    });

	    CompletableFuture<String>[] completableFutures = stream
		    .toArray(CompletableFuture[]::new);
	    CompletableFuture<Void> result = CompletableFuture
		    .allOf(completableFutures);
	    result.join();

	    result.thenApply(v -> {
		System.out.println("ramin");

		for (CompletableFuture<String> completableFuture : completableFutures) {
		    try {
			System.out.println(completableFuture.get());
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
		return null;
	    });
	} catch (Exception exception) {
	    exception.printStackTrace();
	}

    }

    static int[] array1 = null;
    static int[] array2 = null;

    public static void ch10q2c() throws InterruptedException,
	    ExecutionException {
	Object lock = new Object();
	Function<Consumer<Void>, Long> function = consumer -> {
	    synchronized (lock) {
		long startTime = System.currentTimeMillis();
		consumer.accept(null);
		long endTime = System.currentTimeMillis();
		return Math.subtractExact(endTime, startTime);
	    }

	};

	int i = 0;
	boolean flag = true;
	while (flag) {
	    array1 = new Random().ints().limit(i).toArray();
	    array2 = Arrays.copyOf(array1, array1.length);

	    CompletableFuture<Long> sortArray = CompletableFuture
		    .supplyAsync(() -> {
			return function.apply(v -> Arrays.sort(array1));
		    });

	    CompletableFuture<Long> parallelArray = CompletableFuture
		    .<Long> supplyAsync(() -> {
			return function.apply(v -> Arrays.parallelSort(array2));
		    });

	    flag = sortArray.thenCombine(parallelArray, (s, p) -> {
		if (s <= p) {
		    return true;
		} else {
		    System.out.println("sort = " + s);
		    System.out.println("parallel = " + p);
		    return false;
		}
	    }).get();

	    if (!flag) {
		System.out.println("Size = " + i);
	    }
	    i++;

	}

    }

    public static void ch10q2b() throws InterruptedException,
	    ExecutionException {
	ExecutorService executorService = Executors.newCachedThreadPool();
	int size = 8193;
	boolean flag = true;
	while (flag) {
	    Random generator = new Random();
	    int[] array1 = generator.ints(size, 0, size + 1).toArray();
	    int[] array2 = Arrays.copyOf(array1, array1.length);

	    Function<Consumer<?>, Long> function = action -> {
		long start = System.currentTimeMillis();
		action.accept(null);
		long end = System.currentTimeMillis();
		long executionTime = Math.subtractExact(end, start);
		return executionTime;
	    };

	    // Thread for Arrays.sort
	    Callable<Long> task_1 = () -> {
		return function.apply(v -> Arrays.sort(array1));
	    };
	    Future<Long> future_1 = executorService.submit(task_1);

	    Callable<Long> task_2 = () -> {
		return function.apply(v -> Arrays.parallelSort(array2));
	    };

	    Future<Long> future_2 = executorService.submit(task_2);

	    if (future_1.get() > future_2.get()) {
		flag = false;
		System.out.println("ArraysSort = " + future_1.get());
		System.out.println("ArraysParallel = " + future_2.get());
		System.out.println("size = " + size);
	    }
	    size++;
	}

	executorService.shutdown();
    }

    public static void ch10q2() {
	boolean flag = true;
	int i = 0;
	while (flag) {
	    Random generator = new Random();
	    int[] array1 = generator.ints(i, 0, 10000).toArray();
	    int[] array2 = Arrays.copyOf(array1, array1.length);
	    // System.out.println(Arrays.toString(array1));

	    long startTime = System.currentTimeMillis();
	    Arrays.sort(array1);
	    long endTime = System.currentTimeMillis();
	    long delta1 = Math.subtractExact(endTime, startTime);

	    startTime = System.currentTimeMillis();
	    Arrays.parallelSort(array2);
	    endTime = System.currentTimeMillis();
	    long delta2 = Math.subtractExact(endTime, startTime);

	    System.out.println("delta 1 = " + delta1);
	    System.out.println("delta 2 = " + delta2);
	    System.out.println("**************");

	    if (delta2 < delta1) {
		flag = false;
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("delta1 = " + delta1);
		System.out.println("delta2 = " + delta2);
		System.out.println("Size = " + i);
	    }
	    i++;
	}

    }

    // Surprisingly executing this in parallel is slower than sequentially
    // because of overhead
    private static void ch10Q1b() {
	String p = "/home/ramin/workspace/ch10";
	File file = new File(p);
	String word = "git";

	try (Stream<Path> files = Files.list(file.toPath());) {
	    System.out.println("cpu="
		    + Runtime.getRuntime().availableProcessors());
	    long startTime = System.currentTimeMillis();

	    Optional<Path> result = files.parallel().filter((Path path) -> {
		try (Stream<String> contents = Files.lines(path);) {
		    return contents.anyMatch(s -> s.contains(word));
		} catch (IOException exception) {
		    exception.printStackTrace();
		}
		return false;
	    }).findAny();
	    long endTime = System.currentTimeMillis();
	    long perfo = Math.subtractExact(endTime, startTime);
	    System.out.println("time = " + perfo + "ms");
	    System.out.println(result.get());

	} catch (IOException exception) {
	    exception.printStackTrace();
	}
    }

    // Surprisingly executing this in parallel is slower than sequentially
    // because of overhead
    private static void ch10Q1a() {
	// http://www.baeldung.com/java-lambda-exceptions

	String p = "/home/ramin/workspace/ch10";
	File file = new File(p);
	String word = "git";

	try (Stream<Path> files = Files.list(file.toPath());) {
	    System.out.println("cpu="
		    + Runtime.getRuntime().availableProcessors());
	    long startTime = System.currentTimeMillis();

	    Stream<Path> result = files.parallel().filter((Path path) -> {
		try (Stream<String> contents = Files.lines(path);) {
		    return contents.anyMatch(s -> s.contains(word));
		} catch (IOException exception) {
		    exception.printStackTrace();
		}
		return false;
	    });
	    long endTime = System.currentTimeMillis();
	    long perfo = Math.subtractExact(endTime, startTime);
	    System.out.println("time = " + perfo + "ms");
	    result.forEach(System.out::println);

	} catch (IOException exception) {
	    exception.printStackTrace();
	}
    }

    public static void ch9Q15() {

	String file = "/home/ramin/workspace/points.ser";
	Path path = Paths.get(file);
	Point[] clonedPoints = null;
	try (InputStream inputStream = new FileInputStream(path.toFile());
		ObjectInputStream objectInputStream = new ObjectInputStream(
			inputStream)) {
	    System.out.println("Desirializing array from " + file);
	    clonedPoints = (Point[]) objectInputStream.readObject();

	} catch (Exception exception) {
	    exception.printStackTrace();
	}

	System.out.println(Arrays.toString(clonedPoints));
    }

    public static void ch9Q14() {

	int size = 10;
	Point[] points = new Point[size];
	int i = 0;
	while (i < size) {
	    Random generator = new Random();
	    double x = generator.nextDouble() * 100;
	    double y = generator.nextInt(100);
	    Point point = new Point();
	    point.setX(x);
	    point.setY(y);
	    points[i] = point;
	    i++;
	}
	System.out.println(Arrays.toString(points));
	String file = "/home/ramin/workspace/points.ser";
	Path path = Paths.get(file);
	try (OutputStream outputStream = new FileOutputStream(path.toFile());
		ObjectOutputStream objectInputStream = new ObjectOutputStream(
			outputStream)) {
	    System.out.println("Serializing Array at location: " + file);
	    objectInputStream.writeObject(points);

	} catch (Exception exception) {
	    exception.printStackTrace();

	}

	Point[] clonedPoints = null;
	try (InputStream inputStream = new FileInputStream(path.toFile());
		ObjectInputStream objectInputStream = new ObjectInputStream(
			inputStream)) {
	    System.out.println("Desirializing array from " + file);
	    clonedPoints = (Point[]) objectInputStream.readObject();

	} catch (Exception exception) {
	    exception.printStackTrace();
	}

	boolean isEqual = Arrays.equals(points, clonedPoints);
	System.out.println("points: " + points);
	System.out.println("clonedPoints: " + clonedPoints);
	System.out.println("isEqual: " + isEqual);

    }

    public void paint(Graphics page) {
	// paintch9Q8(page);
	paintch9Q9(page);
    }

    public static void ch9Q13() {
	Message message = new Message();
	Message cloneMessage = null;
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	try (ObjectOutputStream outputStream = new ObjectOutputStream(
		byteArrayOutputStream);) {
	    outputStream.writeObject(message);
	} catch (IOException exception) {
	    exception.printStackTrace();
	}
	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
		byteArrayOutputStream.toByteArray());
	try (ObjectInputStream inputStream = new ObjectInputStream(
		byteArrayInputStream)) {
	    cloneMessage = (Message) inputStream.readObject();
	} catch (IOException | ClassNotFoundException exception) {
	    exception.printStackTrace();
	}
	System.out.println("Message:" + message);
	message.print();
	System.out.println("cloneMessage:" + cloneMessage);
	cloneMessage.print();

	Message clone2Message = message.clone();
	System.out.println("Message_clone: " + clone2Message);
	message.recipients.remove(0);
	message.print();
	System.out.println("******");
	clone2Message.print();
    }

    public static void ch9Q12() {
	Pattern regex = Pattern.compile("(\\d{1,2})");
	Matcher regexMatcher = regex.matcher("12 54 1 65");
	try {
	    String resultString = regexMatcher.replaceAll("$1");
	    System.out.println(resultString);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void ch9Q11() {
	String file = "/home/ram\\in/ch\\9q+++11.zip";
	Pattern pattern = Pattern
		.compile("[\\p{Alnum}\\p{Punct}&&[^/]]+.\\w+$");
	Matcher matcher = pattern.matcher(file);
	while (matcher.find()) {
	    System.out.println(matcher.group());
	}
    }

    public static void ch9Q10() {
	String line = "--56--5-hello+kr 389rk-from +105 ++++----89++++ramin -96565 hererl++++389";
	String regx = "[+-]*[[\\D]&&[^+-]]+[+-]*";
	// Solution 1
	Pattern pattern = Pattern.compile("[+-]?[0-9]+");
	Matcher matcher = pattern.matcher(line);
	List<Integer> integers = new ArrayList<Integer>();
	while (matcher.find()) {
	    integers.add(Integer.parseInt(matcher.group()));

	}

	System.out.println(integers);

	// Solution2
	String x = line.replaceAll("[[\\D]&&[^+-]]", "");
	System.out.println(x);
	x = x.replaceAll("[+]+", "+");
	System.out.println(x);
	x = x.replaceAll("[-]+", "-");
	System.out.println(x);
	x = x.replaceAll("[-][+]", "+");
	System.out.println(x);
	x = x.replaceAll("[+][-]", "-");
	System.out.println(x);
	String y[] = x.split("[-]");
	System.out.println(Arrays.toString(y));
	List<Integer> integers2 = new ArrayList<Integer>();
	for (String z : y) {
	    if (z.isEmpty()) {
		continue;
	    }
	    if (z.contains("+")) {
		String[] w = z.split("[+]");
		integers.add(Integer.parseInt(w[0]) * -1);
		int i = 1;
		while (i < w.length) {
		    integers2.add(Integer.parseInt(w[i]));
		    i++;
		}
	    } else {
		integers2.add(Integer.parseInt(z) * -1);
	    }
	}

	System.out.println(integers2);
	// String solution3[] = Arrays.stream(solution2).filter((t) ->
	// t.length()!=0?true:false).toArray(String[]::new);

	// System.out.println(Arrays.toString(solution3));
	// Arrays.asList(solution3).forEach(t ->
	// System.out.println(t.length()));
    }

    public static void paintch9Q9(Graphics page) {
	// see
	// http://www.httpwatch.com/httpgallery/authentication/#showExample10
	try {
	    URL url = new URL(
		    "http://www.httpwatch.com/httpgallery/authentication/authenticatedimage/default.aspx");
	    URLConnection urlConnection = url.openConnection();
	    String userpass = "httpwatch" + ":" + "changeme";
	    String basicAuth = "Basic "
		    + new String(Base64.getEncoder().encode(
			    userpass.getBytes(StandardCharsets.UTF_8)));
	    urlConnection.setRequestProperty("Authorization", basicAuth);

	    // Loading an Image into Applet
	    BufferedImage image = ImageIO.read(urlConnection.getInputStream());
	    page.drawImage(image, 50, 50, null);

	    /*
	     * //Reading a file BufferedReader bufferedReader = new
	     * BufferedReader(new
	     * InputStreamReader(urlConnection.getInputStream())); String
	     * line=null; while((line=bufferedReader.readLine()) != null) {
	     * System.out.println(line); } bufferedReader.close();
	     * urlConnection.connect(); Map<String,List<String>>
	     * headers=urlConnection.getHeaderFields(); headers.forEach((k,v)->
	     * System.out.println(k + ": " + v));
	     */
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    public static void ch9Q8() throws URISyntaxException {
	String file = "/home/ramin/workspace/ch9q8.zip";
	Path zipPath = Paths.get(file);
	try {
	    Files.deleteIfExists(zipPath);
	} catch (Exception exception) {
	    exception.printStackTrace();
	}

	URI uri = new URI("jar", zipPath.toUri().toString(), null);
	// Constructs the URI jar:file://myfile.zip
	try (FileSystem zipfs = FileSystems.newFileSystem(uri,
		Collections.singletonMap("create", "true"))) {

	    // To add files, copy them into the ZIP file system
	    String sourceFile = "/home/ramin/workspace";
	    Path sourcePath = Paths.get(sourceFile);
	    if (Files.isDirectory(sourcePath)) {

		Path[] paths = Files.walk(sourcePath).toArray(Path[]::new);
		for (Path p : paths) {
		    if (p.equals(sourcePath)) {
			continue;
		    }
		    Path source = sourcePath.relativize(p);
		    Path target = zipfs.getPath("/").resolve(source.toString());
		    Files.copy(p, target);
		}
	    }

	} catch (Exception exception) {
	    exception.printStackTrace();
	}
    }

    public static void ch9Q7() {
	String file = "/home/ramin/workspace/Superman-dcuo.bmp";
	Path path = Paths.get(file);
	byte[] bytes = null;
	if (path.toFile().length() < Integer.MAX_VALUE) {
	    bytes = new byte[Long.valueOf(path.toFile().length()).intValue()];
	    try (InputStream inputStream = Files.newInputStream(path)) {
		inputStream.read(bytes);
		MessageDigest messageDigest = MessageDigest
			.getInstance(MessageDigestAlgorithms.SHA_1);
		byte[] bs = messageDigest.digest(bytes);
		String sha = "";
		for (Byte byte1 : bs) {

		    sha = sha + Integer.toHexString(Byte.toUnsignedInt(byte1));
		}

		System.out.println("sha=" + sha);

	    } catch (IOException | NoSuchAlgorithmException exception) {
		exception.printStackTrace();
	    }
	}
    }

    private void paintch9Q8(Graphics page) {
	// ch9Q6
	// see
	// http://www.ece.ualberta.ca/~elliott/ee552/studentAppNotes/2003_w/misc/bmp_file_format/bmp_file_format.htm
	String file = "/home/ramin/workspace/Superman-dcuo.bmp";
	Path path = Paths.get(file);
	int horizontalWidth = 0;
	int verticalWidth = 0;
	int bitsPerPixel = 0;
	int sizeHeader = 0;
	int dataOffset = 0;
	double imageSize = 0;
	double fileSize = 0;
	byte[] bs = null;
	long size = path.toFile().length();
	if (size < Integer.MAX_VALUE) {
	    bs = new byte[(int) size];
	    try (InputStream inputStream = new FileInputStream(path.toFile())) {
		inputStream.read(bs);
	    } catch (IOException exception) {
		exception.printStackTrace();
	    }

	} else {

	    try (InputStream inputStream = new FileInputStream(path.toFile())) {
		byte[] bytes = new byte[1024];
		int n = -1;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		while ((n = inputStream.read(bytes)) != -1) {
		    byteArrayOutputStream.write(bytes, 0, n);
		}
		bs = byteArrayOutputStream != null ? byteArrayOutputStream
			.toByteArray() : null;
		int x = 10;
	    } catch (IOException exception) {
		exception.printStackTrace();
	    }

	}

	sizeHeader = (int) (Byte.toUnsignedInt(bs[14])
		+ Byte.toUnsignedInt(bs[15]) * Math.pow(2, 8)
		+ Byte.toUnsignedInt(bs[16]) * Math.pow(2, 16) + Byte
		.toUnsignedInt(bs[17]) * Math.pow(2, 24));
	horizontalWidth = (int) (Byte.toUnsignedInt(bs[18])
		+ Byte.toUnsignedInt(bs[19]) * Math.pow(2, 8)
		+ Byte.toUnsignedInt(bs[20]) * Math.pow(2, 16) + Byte
		.toUnsignedInt(bs[21]) * Math.pow(2, 24));
	verticalWidth = (int) (Byte.toUnsignedInt(bs[22])
		+ Byte.toUnsignedInt(bs[23]) * Math.pow(2, 8)
		+ Byte.toUnsignedInt(bs[24]) * Math.pow(2, 16) + Byte
		.toUnsignedInt(bs[25]) * Math.pow(2, 24));
	bitsPerPixel = Byte.toUnsignedInt(bs[28]) + Byte.toUnsignedInt(bs[29])
		* (int) Math.pow(2, 8);
	imageSize = Byte.toUnsignedInt(bs[34]) + Byte.toUnsignedInt(bs[35])
		* Math.pow(2, 8) + Byte.toUnsignedInt(bs[36]) * Math.pow(2, 16)
		+ Byte.toUnsignedInt(bs[37]) * Math.pow(2, 24);
	fileSize = Byte.toUnsignedInt(bs[2]) + Byte.toUnsignedInt(bs[3])
		* Math.pow(2, 8) + Byte.toUnsignedInt(bs[4]) * Math.pow(2, 16)
		+ Byte.toUnsignedInt(bs[5]) * Math.pow(2, 24);
	dataOffset = (int) (Byte.toUnsignedInt(bs[10])
		+ Byte.toUnsignedInt(bs[11]) * Math.pow(2, 8)
		+ Byte.toUnsignedInt(bs[12]) * Math.pow(2, 16) + Byte
		.toUnsignedInt(bs[13]) * Math.pow(2, 24));

	System.out.println("sizeHeader=" + sizeHeader);
	System.out.println("horizontalWidth=" + horizontalWidth + " pixels");
	System.out.println("verticalWidth=" + verticalWidth + " pixels");
	System.out.println("bitsPerPixel=" + bitsPerPixel + " bits");
	System.out.println("imageSize=" + imageSize + " bytes");
	System.out.println("fileSize=" + fileSize + " bytes");
	System.out.println("path.toFile().length()=" + size + " bytes");
	System.out.println("dataOffset" + dataOffset);

	int i = dataOffset;
	int x = 1;
	int y = verticalWidth;
	int row = horizontalWidth * 3;
	int padding = (int) Math.ceil((double) row / 4) * 4 - row;

	int k = 0;
	while (i < imageSize) {
	    int blue = 0;
	    int green = 0;
	    int red = 0;
	    if (k < row) {

		blue = Byte.toUnsignedInt(bs[i]);
		green = Byte.toUnsignedInt(bs[i + 1]);
		red = Byte.toUnsignedInt(bs[i + 2]);
		Color pixel = new Color(red, green, blue);

		page.setColor(pixel);
		page.fillRect(x, y, 1, 1);

		if (x == horizontalWidth) {
		    x = 1;
		    y--;
		} else {
		    x++;
		}

		i = i + 3;
		k = k + 3;
	    } else {
		i = i + padding;
		k = 0;
	    }
	}
    }

    private static void ch9Q5() {
	Map<String, Charset> map = Charset.availableCharsets();
	Map<String, String> result = new HashMap<String, String>();
	for (Entry<String, Charset> entry : map.entrySet()) {
	    Charset charset = entry.getValue();
	    try {
		String replacement = new String(charset.newEncoder()
			.replacement(), charset);
		result.merge(replacement, charset.name(), (v1, v2) -> v1 + ", "
			+ v2);
	    } catch (Exception exception) {
		result.merge("NONE", charset.name(), (v1, v2) -> v1 + ", " + v2);
	    }

	}

	result.forEach((k, v) -> System.out.println(k + "->" + v));

    }

    private static void ch9Q4() {

	String file = "/usr/share/dict/american-english";
	Path path = Paths.get(file);

	long bufferedReaderTime = 0;
	try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
	    long start = System.currentTimeMillis();
	    String line = null;
	    while ((line = bufferedReader.readLine()) != null) {
		// nothing
	    }
	    long end = System.currentTimeMillis();
	    bufferedReaderTime = Math.subtractExact(end, start);
	} catch (IOException exception) {
	    exception.printStackTrace();
	}

	long bufferedReaderTime2 = 0;
	try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
	    long start = System.currentTimeMillis();
	    Stream<String> line = bufferedReader.lines();
	    long end = System.currentTimeMillis();
	    bufferedReaderTime2 = Math.subtractExact(end, start);
	} catch (IOException exception) {
	    exception.printStackTrace();
	}

	long scannerTime = 0;
	try (Scanner scanner = new Scanner(path)) {
	    long start = System.currentTimeMillis();
	    while (scanner.hasNextLine()) {
		scanner.nextLine();
	    }
	    long end = System.currentTimeMillis();
	    scannerTime = Math.subtractExact(end, start);
	} catch (IOException exception) {
	    exception.printStackTrace();
	}

	System.out.println("**** Read File Analysis ****");
	System.out.println("bufferedReaderTime: " + bufferedReaderTime + "ms");
	System.out
		.println("bufferedReaderTime2: " + bufferedReaderTime2 + "ms");
	System.out.println("scannerTime: " + scannerTime + "ms");

    }

    private static void ch9Q3() {

	// String fileName = "/home/ramin/workspace/ch9Q3_utf16";
	String fileName = "/home/ramin/workspace/ch9Q3_utf8_bom";
	Map<Charset, Double> results = ch9q3_1(fileName);
	System.out.println("***** Analysis Result *******");
	System.out.println(results);
	Double highestPrecentage = results.entrySet().iterator().next()
		.getValue();
	if (highestPrecentage != 0) {
	    for (Entry<Charset, Double> result : results.entrySet()) {
		Charset standardCharset = result.getKey();
		Double percentage = result.getValue();
		if (percentage.equals(highestPrecentage)) {
		    System.out.println("The file is encoded (" + percentage
			    + "% accuracy) with: " + standardCharset);
		}
	    }
	} else {
	    System.out.println("Unable to find encoder for file: " + fileName);
	}

    }

    private static Map<Charset, Double> ch9q3_1(String file) {
	byte[] bytes = ch9q3_2(file);
	List<String> dictionnary = ch9q3_2();
	Queue<Charset> standardCharSet = ch9q3_3();

	Map<Charset, Double> result = new HashMap<Charset, Double>();

	Charset charset = null;
	boolean found = false;
	while (!found && !standardCharSet.isEmpty()) {
	    charset = standardCharSet.poll();
	    String text = new String(bytes, charset);
	    System.out.println("*** Charset: " + charset + "***");
	    System.out.println(text.length());
	    List<String> words = Stream.of(text.split("[\\P{Alnum}]+"))
		    .map(x -> x.toLowerCase()).collect(Collectors.toList());
	    System.out.println(words);
	    if (words.isEmpty()) {
		result.put(charset, new Double(0));
	    } else {
		if (dictionnary.containsAll(words)) {
		    result.put(charset, new Double(100));
		    found = true;
		} else {
		    int count = 0;
		    for (String word : words) {
			if (dictionnary.contains(word)) {
			    count++;
			}
		    }
		    double percentage = (double) count / words.size();
		    result.put(charset, percentage);
		}

	    }
	}
	Comparator<Entry<Charset, Double>> comparator = (x, y) -> {
	    if (x.getValue() > y.getValue()) {
		return -1;
	    }
	    if (x.getValue() == y.getValue()) {
		return 0;
	    }
	    return 1;
	};
	result = result
		.entrySet()
		.stream()
		.sorted(comparator)
		.collect(
			Collectors.toMap(Entry::getKey, Entry::getValue,
				(x, y) -> x, LinkedHashMap::new));
	return result;
    }

    private static byte[] ch9q3_2(String file) {
	Path path = Paths.get(file);
	byte[] bs = new byte[1000];
	try (InputStream inputStream = Files.newInputStream(path)) {
	    inputStream.read(bs);
	} catch (IOException exception) {
	    exception.printStackTrace();
	}
	return bs;
    }

    private static List<String> ch9q3_2() {
	String file = "/usr/share/dict/american-english";
	List<String> americainEnglishDict = null;
	try {
	    americainEnglishDict = Files.readAllLines(Paths.get(file));

	} catch (IOException e) {

	    e.printStackTrace();
	}

	return americainEnglishDict;
    }

    public static Queue<Charset> ch9q3_3() {
	Deque<Charset> standardCharsets = new ArrayDeque<Charset>();
	standardCharsets.push(StandardCharsets.US_ASCII);
	standardCharsets.push(StandardCharsets.ISO_8859_1);
	standardCharsets.push(StandardCharsets.UTF_8);
	standardCharsets.push(StandardCharsets.UTF_16BE);
	standardCharsets.push(StandardCharsets.UTF_16LE);
	return standardCharsets;
    }

    private static void ch9Q2() {
	String file = "/home/ramin/workspace/AMERICAN_MISSIONARY.html";
	try {
	    List<String> lines = Files.readAllLines(Paths.get(file));
	    Map<String, Set<Integer>> map = new TreeMap<String, Set<Integer>>();
	    int i = 1;
	    for (String line : lines) {
		String[] words = line.split("[\\s]");
		int j = 0;
		while (j < words.length) {
		    Set<Integer> value = new HashSet<Integer>();
		    value.add(i);
		    map.merge(words[j], value, (t, u) -> {
			t.addAll(u);
			return t;
		    });
		    j++;
		}
		i++;
	    }
	    map.forEach((k, v) -> System.out.println(k + " = " + v));

	} catch (IOException exception) {
	    exception.printStackTrace();
	}

    }

    private static void ch9Q1b() throws FileNotFoundException, IOException {

	// copying content into memory
	String file = "/home/ramin/workspace/AMERICAN_MISSIONARY.html";
	InputStream inputStream = new FileInputStream(Paths.get(file).toFile());
	byte b[] = new byte[1024];
	int len;
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	while ((len = inputStream.read(b)) != -1) {
	    outputStream.write(b, 0, len);
	}
	byte[] bytes = outputStream.toByteArray();
    }

    private static void ch9q1a() {
	String file = "/home/ramin/workspace/AMERICAN_MISSIONARY.html";
	String file2 = "/home/ramin/workspace/AMERICAN_MISSIONARY_2.html";
	Path path = Paths.get(file);
	byte array[] = null;
	try (InputStream inputStream = new FileInputStream(path.toFile());) {
	    array = new byte[(int) Files.size(path)];
	    inputStream.read(array);
	} catch (Exception exception) {
	    exception.printStackTrace();
	}

	try (OutputStream outputStream = new FileOutputStream(Paths.get(file2)
		.toFile())) {
	    outputStream.write(array);

	} catch (Exception exception) {
	    exception.printStackTrace();
	}

    }

    private static void ch8q17() {
	Path path = Paths.get("/home/ramin/Documents/warAndPeace.htm");
	try (Stream<String> stream = Files.lines(path)) {
	    Map<Integer, List<String>> map = stream.flatMap(
		    t -> Stream.of(t.split("\\s"))).collect(
		    Collectors.groupingBy(String::length));

	    map.entrySet()
		    .stream()
		    .sorted(Comparator
			    .<Entry<Integer, List<String>>, Integer> comparing(
				    Entry<Integer, List<String>>::getKey)
			    .reversed()).flatMap(e -> e.getValue().stream())
		    .sequential().distinct().limit(500)
		    .forEach(System.out::println);

	} catch (IOException exception) {
	    exception.printStackTrace();
	    StringWriter stringWritter = new StringWriter();
	    exception.printStackTrace(new PrintWriter(stringWritter));
	}
    }

    private static void ch8q16() {
	Path path = Paths.get("/home/ramin/Documents/warAndPeace.htm");
	try (Stream<String> stream = Files.lines(path)) {
	    Map<Integer, List<String>> map = stream.flatMap(
		    t -> Stream.of(t.split("\\s"))).collect(
		    Collectors.groupingBy(String::length));

	    map.entrySet()
		    .stream()
		    .parallel()
		    .sorted(Comparator
			    .<Entry<Integer, List<String>>, Integer> comparing(
				    Entry<Integer, List<String>>::getKey)
			    .reversed()).flatMap(e -> e.getValue().stream())
		    .sequential().limit(500).forEach(System.out::println);

	} catch (IOException exception) {
	    exception.printStackTrace();
	}
    }

    private static void ch8q15() {
	Stream.<BigInteger> iterate(BigInteger.ONE.pow(50), t -> {
	    do {
		t = t.add(BigInteger.ONE);
	    } while (!t.isProbablePrime(100));
	    return t;
	}).limit(500).forEach(System.out::println);
    }

    private static void ch8q14a() {

	Random random = new Random();
	List<Double> list = random.doubles(0, 100).limit(500).boxed()
		.collect(Collectors.toList());
	// System.out.println("list = " + list);
	double average = list.stream().mapToDouble(t -> t).average()
		.getAsDouble();
	System.out.println("average = " + average);

	class Averager {
	    int count = 0;
	    double sum = 0;

	    public synchronized Averager sum(double d) {

		sum = sum + d;
		count++;
		return this;
	    }

	    public Averager combine(Averager d) {
		return this;
	    }

	    public double average() {
		return count == 0 ? 0 : sum / count;
	    }

	    public String toString() {
		String result = "Sum=" + sum + " Count=" + count + " Average="
			+ average();
		return result;
	    }
	}

	BiFunction<Averager, Double, Averager> biFunction = Averager::sum;
	BinaryOperator<Averager> binaryOperator = Averager::combine;
	Averager averager = list.stream().reduce(new Averager(), biFunction,
		binaryOperator);
	System.out.println(averager);

    }

    private static void ch8q14b() {

	Random random = new Random();
	List<Double> list = random.doubles(0, 100).limit(500).boxed()
		.collect(Collectors.toList());
	// System.out.println("list = " + list);
	double average = list.stream().mapToDouble(t -> t).average()
		.getAsDouble();
	System.out.println("average = " + average);

	class Averager {
	    int count = 0;
	    double sum = 0;

	    public Averager() {
		this.sum = 0;
		this.count = 0;
	    }

	    public Averager(Averager avg) {
		this.sum = avg.sum;
		this.count = avg.count;
	    }

	    public void sum(double d) {
		sum = sum + d;
		count++;
	    }

	    public Averager accumulate(double d) {
		Averager averager = new Averager(this);
		averager.sum(d);
		return averager;

	    }

	    public Averager combine(Averager avg) {
		Averager averager = new Averager(this);
		averager.sum = averager.sum + avg.sum;
		averager.count = averager.count + avg.count;
		return averager;
	    }

	    public double average() {
		return count == 0 ? 0 : sum / count;
	    }

	    public String toString() {
		String result = "Sum=" + sum + " Count=" + count + " Average="
			+ average();
		return result;
	    }
	}

	Averager averager = list
		.stream()
		.parallel()
		.reduce(new Averager(), Averager::accumulate, Averager::combine);
	System.out.println(averager);

    }

    private static void ch8q13() {
	Random random = new Random();

	Stream<List<Integer>> stream = new ArrayList<List<Integer>>(
		Collections.nCopies(random.nextInt(5), null)).stream();

	List<List<Integer>> l2 = stream.map(
		t -> random.ints(0, 1000).limit(5).boxed()
			.collect(Collectors.toList())).collect(
		Collectors.toList());

	// Methodology 1: accumulator
	BinaryOperator<List<Integer>> accumulator = (x, y) -> {
	    List<Integer> z = new ArrayList<>(x);
	    z.addAll(y);
	    return z;
	};

	List<Integer> list = l2.stream().reduce(accumulator).get();
	System.out.println("list =" + list);
	System.out.println("l2 = " + l2);

	// Methodology 2: accumulator + identity
	List<Integer> identity = new ArrayList<Integer>();
	List<Integer> l3 = l2.stream().reduce(identity, accumulator);
	System.out.println("l2 = " + l2);
	System.out.println("l3 = " + l3);
	System.out.println(list.equals(l3));

	// Methodology 3: accumulator + identity + combiner
	BinaryOperator<List<Integer>> combiner = (p, q) -> {
	    System.out.println("p=" + p);
	    System.out.println("q=" + q);
	    List<Integer> r = new ArrayList<>(p);
	    r.addAll(q);
	    return r;
	};

	List<Integer> l4 = l2.stream().parallel()
		.reduce(identity, accumulator, combiner);
	System.out.println("l2 = " + l2);
	System.out.println("l4 = " + l4);
	System.out.println(list.equals(l4));
    }

    public static <T> Stream<T> zip(Stream<T> stream, Stream<T> stream2) {
	List<T> l1 = stream.collect(Collectors.toList());
	List<T> l2 = stream2.collect(Collectors.toList());
	List<T> l3 = new ArrayList<T>();

	int s1 = l1.size();
	int s2 = l2.size();
	int smax = 0;
	if (s1 >= s2) {
	    smax = s1;
	} else {
	    smax = s2;
	}
	int i = 0;
	while (i < smax) {
	    if (i < s1) {
		l3.add(l1.get(i));
	    } else {
		l3.add(null);
	    }

	    if (i < s2) {
		l3.add(l2.get(i));
	    } else {
		l3.add(null);
	    }
	    i++;
	}
	return l3.stream();
    }

    public static <T> boolean isFinite(Stream<T> stream) {
	long l = stream.count();
	System.out.println("l = " + l);
	return true;
    }

    private static void ch8q10a() {
	Path path = Paths.get("/usr/share/dict/words");
	try (Stream<String> stream = Files.lines(path)) {
	    Map<Integer, List<String>> map = stream.collect(Collectors
		    .groupingBy(String::length));
	    Optional<Entry<Integer, List<String>>> opt = map
		    .entrySet()
		    .stream()
		    .max(Comparator
			    .<Entry<Integer, List<String>>, Integer> comparing(Entry::getKey));
	    opt.ifPresent(System.out::println);
	} catch (Exception exception) {
	    exception.printStackTrace();
	}
    }

    private static void ch8q10b() {
	Path path = Paths.get("/usr/share/dict/words");
	try (Stream<String> stream = Files.lines(path)) {
	    Map<Integer, List<String>> map = stream.collect(Collectors
		    .groupingBy(String::length));
	    TreeMap<Integer, List<String>> treeMap = new TreeMap<Integer, List<String>>(
		    Comparator.<Integer, Integer> comparing(t -> t));
	    treeMap.putAll(map);
	    treeMap.forEach((Integer k, List<String> v) -> System.out.println(k
		    + "= " + v));
	    System.out.println(treeMap.get(treeMap.lastKey()));
	} catch (Exception exception) {
	    exception.printStackTrace();
	}
    }

    private static void ch8q9() {
	Path path = Paths.get("/usr/share/dict/words");
	try (Stream<String> stream = Files.lines(path)) {
	    Double d = stream.map(t -> t.length()).collect(
		    Collectors.averagingInt(t -> t));
	    System.out.println("average = " + d);

	} catch (IOException exception) {
	    exception.printStackTrace();
	}
    }

    private static void ch8q8b() {

	Predicate<String> exactlyLeastSixVowels = t -> {
	    t = t.toLowerCase();
	    Character[] v = { 'a', 'e', 'i', 'o', 'u', 'y' };
	    Set<Character> cp = new HashSet<Character>(Arrays.asList(v));
	    Set<Character> vowels = new HashSet<Character>(cp);
	    for (int i = 0; i < t.length(); i++) {
		Character c = t.charAt(i);
		if (vowels.contains(c)) {
		    if (!cp.remove(c))
			return false;
		}
	    }

	    if (cp.isEmpty()) {
		return true;
	    }
	    return false;
	};

	Path path = Paths.get("/usr/share/dict/words");
	try (Stream<String> lines = Files.lines(path)) {
	    lines.filter(exactlyLeastSixVowels).forEach(System.out::println);
	} catch (IOException exception) {
	    exception.printStackTrace();
	}
    }

    private static void ch8q8a() {
	Path path = Paths.get("/usr/share/dict/words");
	try (Stream<String> lines = Files.lines(path)) {
	    Predicate<String> atLeastSixVowels = t -> {
		t = t.toLowerCase();
		Character[] v = { 'a', 'e', 'i', 'o', 'u', 'y' };
		Set<Character> vowels = new HashSet<Character>(Arrays.asList(v));
		for (int i = 0; i < t.length(); i++) {
		    if (vowels.contains(t.charAt(i))) {
			vowels.remove(t.charAt(i));
		    }
		}
		return vowels.isEmpty() ? true : false;
	    };

	    lines.filter(atLeastSixVowels).forEach(System.out::println);
	} catch (IOException exception) {
	    exception.printStackTrace();
	}
    }

    private static void ch8q7() {
	Path path = Paths.get("/home/ramin/.bashrc");
	mostFreqWords(path);
    }

    private static void mostFreqWords(Path path) {
	try (Stream<String> lines = Files.lines(path)) {

	    // Transforming a stream of lines to a stream of words
	    Stream<String> stream = lines.flatMap(
		    x -> Stream.of(x.split("[\\s]+")))
		    .filter(y -> !y.isEmpty());

	    // Transforming a stream of words to a Map with key words and value
	    // the frequency count of the word
	    Map<String, Long> map = stream.collect(Collectors.groupingBy(
		    Function.identity(), Collectors.counting()));
	    System.out.println(map);

	    // Finding the most used word
	    Optional<Entry<String, Long>> opt = map
		    .entrySet()
		    .stream()
		    .collect(
			    Collectors.maxBy(Comparator
				    .<Entry<String, Long>> comparingLong(Entry::getValue)));
	    opt.ifPresent(System.out::println);

	    // Finding the most used words
	    Stream<Entry<String, Long>> stream2 = map.entrySet().stream();
	    stream2.sorted(
		    Comparator.<Entry<String, Long>> comparingLong(
			    Entry::getValue).reversed()).limit(10)
		    .forEachOrdered(System.out::println);

	    // https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values-java
	    // https://www.mkyong.com/java/how-to-sort-a-map-in-java/

	} catch (IOException exception) {
	    exception.printStackTrace();
	}

    }

    private static void first100Tokens(Path path) {
	try (Stream<String> stream = Files.lines(path)) {
	    Stream<String> stream2 = stream.flatMap(w -> Stream.<String> of(
		    w.split("[\\s]+")).filter(x -> !x.isEmpty()));
	    stream2.filter(w -> isWord(w)).limit(100)
		    .forEach(System.out::println);

	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static boolean isWord(String w) {
	return w.codePoints().allMatch(Character::isAlphabetic);
    }

    public static boolean isJavaIdentifier(String w) {
	return Character.isJavaIdentifierStart(w.charAt(0))
		&& w.substring(1, w.length() - 1).codePoints()
			.allMatch(x -> Character.isJavaIdentifierPart(x));
    }

    public String getUerFromDB(Map<String, Integer> map) {
	Map<String, Integer> map2 = new HashMap<>();
	Map<? extends String, ? extends Integer> map3 = map2;

	return "not yet implemented";

    }

    public static <T> T somef() {
	return null;
    }

    public void quickSort(int[] array) {

	quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int p, int r) {
	System.out.println("*********");
	System.out.println(Arrays.toString(array));
	System.out.println("p=" + p);
	System.out.println("r=" + r);
	if (r <= p) {

	    return;
	}
	int q = partition(array, p, r);

	System.out.println(Arrays.toString(array));
	quickSort(array, p, q - 1);
	quickSort(array, q + 1, r);
    }

    private int partition(int[] array, int p, int r) {

	int x = p - 1;
	int y = p - 1;
	int pivot = array[r];
	int i = p;
	while (i < r) {
	    int z = array[i];
	    if (z < pivot) {
		x++;
		y++;
		array[y] = array[x];
		array[x] = z;
	    } else {
		y++;
	    }
	    i++;
	}

	int q = x + 1;
	array[r] = array[q];
	array[q] = pivot;
	return q;

    }

    public void mergeSort(int[] array) {

	mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int p, int r) {

	if (r == p) {
	    return;
	}

	int q = (p + r) / 2;
	mergeSort(array, p, q);
	mergeSort(array, q + 1, r);

	merge(array, p, r);
    }

    private void merge(int[] array, int p, int r) {
	int q = (p + r) / 2;
	int[] lhs = Arrays.copyOfRange(array, p, q + 1);
	int[] rhs = Arrays.copyOfRange(array, q + 1, r + 1);

	int i = 0;
	int j = 0;
	while (p <= r) {
	    if (lhs[i] < rhs[j]) {
		array[p] = lhs[i];
		i++;
		p++;
	    } else {
		array[p] = rhs[j];
		j++;
		p++;
	    }

	    if (i == lhs.length) {
		while (j < rhs.length) {
		    array[p] = rhs[j];
		    j++;
		    p++;
		}
	    }

	    if (j == rhs.length) {
		while (i < lhs.length) {
		    array[p] = lhs[i];
		    i++;
		    p++;
		}
	    }
	}
    }

    public int binarySearch(int[] array, int searchValue) {

	return binarySearch(array, searchValue, 0, array.length - 1);
    }

    private int binarySearch(int[] array, int searchValue, int p, int r) {
	int q = (p + r) / 2;
	int z = array[q];
	if (z == searchValue) {
	    return q;
	}

	if (r <= p) {
	    return -1;
	}

	if (z < searchValue) {
	    return binarySearch(array, searchValue, q + 1, r);
	} else {
	    return binarySearch(array, searchValue, p, q - 1);
	}

    }

    public void selectionSort(int[] actual) {

	int i = 0;
	int size = actual.length;

	while (i < size) {
	    int minIndex = i;
	    int min = actual[minIndex];

	    int j = i;
	    while (j < size) {
		if (actual[j] < min) {
		    min = actual[j];
		    minIndex = j;
		}
		j++;
	    }
	    actual[minIndex] = actual[i];
	    actual[i] = min;

	    i++;
	}
    }

    public void insertionSort(int[] actual) {

	int size = actual.length;
	int i = 0;
	while (i < size) {
	    int j = i;
	    int z = actual[j];
	    while (j > 0) {
		if (actual[j - 1] > z) {
		    actual[j] = actual[j - 1];
		    j--;
		} else {
		    break;
		}

	    }
	    actual[j] = z;
	    i++;
	}

    }

    public static void selectionSort1(int[] array) {

	int i = 0;
	int size = array.length;
	while (i < size) {
	    int min = array[i];
	    int min_index = i;
	    int j = i + 1;
	    while (j < size) {
		if (array[j] < min) {
		    min = array[j];
		    min_index = j;
		}
		j++;
	    }
	    array[min_index] = array[i];
	    array[i] = min;
	    i++;
	}
    }

    public static void quickSort1(int[] array) {

	quickSort1(array, 0, array.length - 1);
    }

    private static void quickSort1(int[] array, int p, int r) {
	if (r <= p) {
	    return;
	}
	int q = partion1(array, p, r); // q is element of [p,r]
	quickSort1(array, p, q - 1);
	quickSort1(array, q + 1, r);
    }

    private static int partion1(int[] array, int p, int r) {
	int pivot = array[r];
	int lt = p - 1;
	int gte = p - 1;

	int i = p;
	while (i < r) {
	    int z = array[i];
	    if (z < pivot) {
		lt++;
		gte++;
		array[gte] = array[lt];
		array[lt] = z;
	    } else {
		gte++;
	    }
	    i++;
	}
	int q = lt + 1;
	array[r] = array[q];
	array[q] = pivot;
	return q;
    }

    public static void mergeSort1(int[] array) {

	mergeSort1(array, 0, array.length - 1);
    }

    private static void mergeSort1(int[] array, int p, int r) {

	if (r == p) {
	    return;
	}
	int q = (p + r) / 2;
	mergeSort1(array, p, q);
	mergeSort1(array, q + 1, r);

	int[] lhs = Arrays.copyOfRange(array, p, q + 1);
	int[] rhs = Arrays.copyOfRange(array, q + 1, r + 1);

	int i = 0;
	int j = 0;
	while (p <= r) {
	    if (lhs[i] <= rhs[j]) {

		array[p] = lhs[i];
		i++;
		p++;

		if (i == lhs.length) {
		    while (j < rhs.length) {
			array[p] = rhs[j];
			j++;
			p++;
		    }
		}

	    } else {
		array[p] = rhs[j];
		j++;
		p++;

		if (j == rhs.length) {
		    while (i < lhs.length) {
			array[p] = lhs[i];
			i++;
			p++;
		    }
		}

	    }

	}
    }

    public static void insertionSort_1(int[] array) {

	int length = array.length;
	int i = 1;
	while (i < length) {
	    int z = array[i];
	    int j = i - 1;
	    while (j >= 0) {
		if (array[j] > z) {
		    array[j + 1] = array[j];
		    j--;
		} else {
		    break;
		}
	    }
	    array[j + 1] = z;
	    i++;
	}
    }

    public static void bubleSort(int[] array) {

	int lastSortedIndex = array.length - 1;
	while (lastSortedIndex > 0) {
	    int i = 0;
	    while (i < lastSortedIndex) {
		if (array[i] > array[i + 1]) {
		    int temp = array[i + 1];
		    array[i + 1] = array[i];
		    array[i] = temp;
		}

		i++;
	    }
	    lastSortedIndex = lastSortedIndex - 1;
	}
    }

    public static void selectionSort2(int[] actual) {
	int i = 0;
	while (i < actual.length) {
	    int j = i + 1;
	    int lowestInteger = i;
	    int lowestValue = actual[i];
	    while (j < actual.length) {
		if (lowestValue > actual[j]) {
		    lowestInteger = j;
		    lowestValue = actual[j];
		}
		j++;
	    }
	    int temp = actual[i];
	    actual[i] = actual[lowestInteger];
	    actual[lowestInteger] = temp;
	    i++;
	}

    }

    public static void bubleSort_1(int[] actual) {

	int size = actual.length;
	while (size > 0) {
	    int i = 0;
	    while (i < size) {

		if (i != size - 1 && actual[i] > actual[i + 1]) {
		    int temp = actual[i];
		    actual[i] = actual[i + 1];
		    actual[i + 1] = temp;
		}
		i++;
	    }
	    size--;

	}
    }

    public static void selectionSort3(int[] actual) {
	int i = 0;
	while (i < actual.length) {
	    int lowestIndex = i;
	    int j = i + 1;
	    while (j < actual.length) {
		if (actual[j] < actual[lowestIndex]) {
		    lowestIndex = j;
		}
		j++;
	    }
	    int min = actual[lowestIndex];
	    actual[lowestIndex] = actual[i];
	    actual[i] = min;
	    i++;
	}

    }

    public static void insertionSort_2(int[] array) {

	int i = 1;
	while (i < array.length) {
	    int temp = array[i];
	    int j = i - 1;
	    while (j >= 0 && array[j] > temp) {
		array[j + 1] = array[j];
		j--;
	    }
	    array[j + 1] = temp;
	    i++;
	}

    }

    public static void bubleSort_2(int[] array) {

	int size = array.length;

	while (size > 0) {
	    int i = 0;
	    while (i < size) {
		if (i == size - 1) {
		    break;
		}

		if (array[i] > array[i + 1]) {
		    int temp = array[i + 1];
		    array[i + 1] = array[i];
		    array[i] = temp;
		}
		i++;
	    }
	    size--;
	}
    }

    public static void shellSort(int[] array) {
	int gap = array.length / 2;
	while (gap > 0) {
	    int i = gap;
	    while (i < array.length) {
		int element = array[i];
		int j = i - gap;
		while (j >= 0 && array[j] > element) {
		    array[j + gap] = array[j];
		    j = j - gap;
		}
		array[j + gap] = element;
		i++;
	    }
	    gap = gap / 2;
	}
    }

    public static void shellSort_1(int[] array) {
	int gap = array.length / 2;
	while (gap != 0) {
	    int i = gap;
	    while (i < array.length) {
		int temp = array[i];
		int j = i - gap;
		while (j >= 0) {
		    if (temp < array[j]) {
			array[j + gap] = array[j];
			j = j - gap;
		    } else {
			break;
		    }

		}
		array[j + gap] = temp;
		i++;
	    }
	    gap = gap / 2;
	}

    }

    public static void insertionSort_3(int[] array) {
	int i = 1;
	while (i < array.length) {
	    int j = i - 1;
	    int temp = array[i];
	    while (j >= 0) {
		if (array[j] > temp) {
		    array[j + 1] = array[j];
		} else {
		    break;
		}
		j--;
	    }
	    array[j + 1] = temp;
	    i++;
	}
    }

    public static void bubleSort_3(int[] array) {

	int size = array.length;
	while (size > 0) {
	    int i = 0;
	    while (i < size) {
		if (i != size - 1 && array[i] > array[i + 1]) {
		    int temp = array[i];
		    array[i] = array[i + 1];
		    array[i + 1] = temp;
		}
		i++;
	    }
	    size--;
	}

    }

    public static void selectionSort_4(int[] array) {
	int i = 0;
	while (i < array.length) {

	    int j = i;
	    int lowestIndex = j;
	    while (j < array.length) {
		if (array[j] < array[lowestIndex]) {
		    lowestIndex = j;
		}
		j++;
	    }

	    int temp = array[lowestIndex];
	    array[lowestIndex] = array[i];
	    array[i] = temp;
	    i++;
	}

    }

    public static void mergeSort_2(int[] array) {

	mergeSort_2(array, 0, array.length - 1);
    }

    public static void mergeSort_2(int[] array, int p, int r) {
	if (p == r) {
	    return;
	}
	int q = (p + r) / 2;
	mergeSort_2(array, p, q);
	mergeSort_2(array, q + 1, r);

	int[] lhs = Arrays.copyOfRange(array, p, q + 1);
	int[] rhs = Arrays.copyOfRange(array, q + 1, r + 1);

	// optimization 1
	if (array[q] <= array[q + 1]) {
	    return;
	}

	// optimization 2
	if (r - p == 1) {
	    // simple swap for merging cells of size 1 (leafs)
	    int temp = array[p];
	    array[p] = array[r];
	    array[r] = temp;
	}
	int index = p;
	int i = 0;
	int j = 0;
	while (index <= r) {
	    // Equal sign is important to keep the sort stable
	    if (lhs[i] <= rhs[j]) {
		array[index] = lhs[i];
		i++;
	    } else {
		array[index] = rhs[j];
		j++;
	    }
	    index++;

	    // Optimization 3
	    if (i == lhs.length) {
		// Don't need to to anything since all elements are in proper
		// space
		break;
	    }

	    // Optimization 4
	    if (j == rhs.length) {
		while (i < lhs.length) {
		    array[index] = lhs[i];
		    i++;
		    index++;
		}
	    }
	}

    }

    public static void quickSort_2(int[] actual) {
	quickSort_2(actual, 0, actual.length - 1);
    }

    private static void quickSort_2(int[] actual, int start, int end) {

	if (start >= end) {
	    return;
	}
	int pivotIndex = partition_2(actual, start, end);
	quickSort_2(actual, start, pivotIndex - 1);
	quickSort_2(actual, pivotIndex + 1, end);

    }

    private static int partition_2(int[] array, int start, int end) {

	int pivot = array[end];
	int lt = start - 1;
	int gt = start;
	while (gt < end) {

	    if (array[gt] < pivot) {
		lt++;
		if (lt != gt) {
		    int temp = array[lt];
		    array[lt] = array[gt];
		    array[gt] = temp;
		}
	    }
	    gt++;
	}

	int pivotIndex = lt + 1;
	array[end] = array[pivotIndex];
	array[pivotIndex] = pivot;
	return pivotIndex;
    }

    public static void quickSort_3(int[] array) {

	quickSort_3(array, 0, array.length - 1);

    }

    private static void quickSort_3(int[] array, int start, int end) {

	if (end <= start) {
	    return;
	}
	int index = partition_3A(array, start, end);
	quickSort_3(array, start, index - 1);
	quickSort_3(array, index + 1, end);
    }

    private static int partition_3(int[] array, int start, int end) {

	int lt = start;
	int gt = end;
	int pivot = array[end];
	// int pivot_index = gt;

	while (lt < gt) {
	    if (array[lt] >= pivot) {
		// pivot_index = lt;
		array[gt] = array[lt];
		gt--;
		while (gt > lt) {
		    if (array[gt] < pivot) {
			// pivot_index = gt;
			array[lt] = array[gt];
			lt++;
			break;
		    }
		    gt--;

		}

	    } else {
		lt++;
	    }
	}
	System.out.println("lt = " + lt + " gt = " + gt);
	array[lt] = pivot;
	return lt;
    }

    public static int partition_3A(int[] array, int start, int end) {
	int i = start;
	int j = end;
	int pivot = array[j];
	while (i < j) {
	    while (i < j) {
		if (array[i] >= pivot) {
		    break;
		}
		i++;
	    }
	    array[j] = array[i];
	    while (j > i) {
		if (array[j] < pivot) {
		    break;
		}
		j--;
	    }
	    array[i] = array[j];
	}
	assert i == j;
	array[i] = pivot;
	return i;
    }

    public static void countSort(int[] array, int min, int max) {

	int temp[] = new int[max - min + 1];
	// index = value - min
	// value = index +min

	int i = 0;
	while (i < array.length) {
	    int index = array[i] - min;
	    temp[index] = temp[index] + 1;
	    i++;
	}

	int index = 0;
	int j = 0;
	while (index < temp.length) {
	    int count = temp[index];
	    if (count != 0) {
		int k = 0;
		while (k < count) {
		    array[j] = index + min;
		    k++;
		    j++;
		}
	    }
	    index++;
	}

    }

    public static void radixSort(int[] array) {

	int max = findMax(array);

	int width = Integer.toString(max).length();

	int w = 0;
	while (w < width) {
	    stableCountSort(array, w);
	    w++;
	}

    }

    static int findMax(int[] array) {
	int i = 0;
	int max = array[i];
	while (i < array.length) {
	    if (array[i] > max) {
		max = array[i];
	    }
	    i++;
	}
	return max;
    }

    public static void stableCountSort(int[] array, int w) {
	int length = array.length;
	int digits[] = getDigits(array, w);
	int freqArray[] = getFrequencyArray(array, digits);
	adjustFrequency(freqArray);
	sort(array, digits, freqArray);

    }

    public static void sort(int[] array, int[] digits, int[] freqArray) {
	int length = array.length;
	int temp[] = new int[length];

	int i = length - 1;
	while (i >= 0) {

	    int index = freqArray[digits[i]] - 1;
	    freqArray[digits[i]] = index;
	    temp[index] = array[i];
	    i--;
	}

	System.arraycopy(temp, 0, array, 0, temp.length);

    }

    static int[] getFrequencyArray(int[] array, int[] digits) {
	int freqArray[] = new int[10];
	int i = 0;
	while (i < array.length) {
	    int value = digits[i];
	    freqArray[value] = freqArray[value] + 1;
	    i++;
	}
	return freqArray;
    }

    static int[] getDigits(int[] array, int w) {

	int length = array.length;
	int digits[] = new int[length];
	int i = 0;
	while (i < length) {
	    digits[i] = getDigit(array[i], w);
	    i++;
	}
	return digits;
    }

    static int getDigit(int a, int w) {

	int n = 10;
	int q = a;
	int i = 0;
	int r = -1;
	while (i <= w) {
	    r = q % n;
	    q = q / n;
	    if (q == 0 && r == 0) {
		break;
	    }
	    i++;
	}

	return r;
    }

    static void adjustFrequency(int[] frequencyArray) {
	int i = 0;
	int sum = 0;
	int length = frequencyArray.length;
	while (i < length) {
	    sum = frequencyArray[i] + sum;
	    frequencyArray[i] = sum;
	    i++;
	}

    }

    static public int Oddonacci(int n) {
	if (n <= 0) {
	    return 0;
	}
	if (n <= 3) {
	    return 1;
	}
	return Oddonacci(n - 1) + Oddonacci(n - 2) + Oddonacci(n - 3);
    }

    public static void mergeSortDescending(int[] array) {

	mergeSortDescending(array, 0, array.length - 1);

    }

    private static void mergeSortDescending(int[] array, int p, int r) {

	if (p == r) {
	    return;
	}

	int q = (p + r) / 2;
	mergeSortDescending(array, p, q);
	mergeSortDescending(array, q + 1, r);

	if (array[q] < array[q + 1]) {
	    int[] lhs = Arrays.copyOfRange(array, p, q + 1);
	    int[] rhs = Arrays.copyOfRange(array, q + 1, r + 1);

	    int i = p;
	    int x = 0;
	    int y = 0;
	    while (i <= r) {
		if (lhs[x] > rhs[y]) {
		    array[i] = lhs[x];
		    i++;
		    x++;
		} else {
		    array[i] = rhs[y];
		    i++;
		    y++;
		}

		if (y == rhs.length) {
		    while (x < lhs.length) {
			array[i] = lhs[x];
			i++;
			x++;
		    }
		}

		if (x == lhs.length) {
		    break;
		}

	    }
	}
    }

    public static void insertionSort_Recursion(int[] array) {
	insertionSort_Recursion(array, array.length - 1);
    }

    private static void insertionSort_Recursion(int[] array, int index) {
	if (index == 0) {
	    return;
	}

	// making sure that array index-1 is sorted
	insertionSort_Recursion(array, index - 1);

	int value = array[index];
	if (array[index - 1] > value) {
	    // swap
	    array[index] = array[index - 1];
	    array[index - 1] = value;
	    // resort
	    insertionSort_Recursion(array, index - 1);

	} else {
	    // nothing to do
	    return;
	}

    }

    public static void radixSort(String[] array) {
	int max = array[0].length();
	int i = 1;
	while (i < array.length) {
	    int wordLength = array[i].length();
	    if (wordLength > max) {
		max = wordLength;
	    }
	    i++;
	}

	int index = 0;
	while (index < max) {

	    // Extract character + Counter
	    int[] characterCounter = new int[95];
	    int j = 0;
	    while (j < array.length) {
		String word = array[j];
		int delta = max - word.length();
		char character = index < delta ? 32 : word.charAt(max - index
			- 1);
		int characterIndex = character - 32;
		characterCounter[characterIndex]++;
		j++;
	    }

	    // Frequency
	    int k = 1;
	    while (k < characterCounter.length) {
		characterCounter[k] = characterCounter[k]
			+ characterCounter[k - 1];
		k++;
	    }

	    String[] temp = Arrays.copyOf(array, array.length);
	    int z = temp.length - 1;
	    while (z >= 0) {
		String word = temp[z];
		int delta = max - word.length();
		char character = index < delta ? 32 : word.charAt(max - index
			- 1);
		int characterIndex = character - 32;
		int pos = characterCounter[characterIndex] - 1;
		characterCounter[characterIndex] = pos;
		array[pos] = temp[z];
		z--;
	    }
	    index++;
	}
	System.out.println(Arrays.toString(array));
    }

}
