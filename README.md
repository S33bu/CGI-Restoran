# CGI-Restoran

# Projekti kirjeldus 

Tegemist on restorani laua broneerimise ja soovitamise veebirakendusega. 
<br>
Lahendus on loodud Vue.js front-end ning Spring Boot back-end raamistiku abil.  


# Kuidas käivitada?

## Navigeeri frontend kausta

```
cd frontend
```

## Projekti ülesehitus 

```
npm install
```

## Jooksuta backend ja frontend korraga

```
npm run dev
```

## Ava projekt aadressil 

```
localhost:5173
```
# Töö protsess

Lahenduse loomiseks kulus ligikaudu ~15h.

# Lahendused

1. Kõige alguses lõin backendi klassi Laud.java, et salvestada infot iga restorani laua kohta.
  ```
  public Laud(int lauaNr, int kohtadeArv, ArrayList<LocalDateTime> reserveeringud) 
  ```
* Otsustasin, et restoranis oleks 10 lauda ning lõin need vastavalt:
  ```
  Laud laud1 = new Laud(1, 2, new ArrayList<>()); // 2 istet
  Laud laud2 = new Laud(2, 2, new ArrayList<>()); // 2 istet
  Laud laud3 = new Laud(3, 2, new ArrayList<>()); // 2 istet
  Laud laud4 = new Laud(4, 4, new ArrayList<>()); // 4 istet
  Laud laud5 = new Laud(5, 4, new ArrayList<>()); // 4 istet
  Laud laud6 = new Laud(6, 4, new ArrayList<>()); // 4 istet
  Laud laud7 = new Laud(7, 6, new ArrayList<>()); // 6 istet
  Laud laud8 = new Laud(8, 6, new ArrayList<>()); // 6 istet
  Laud laud9 = new Laud(9, 6, new ArrayList<>()); // 6 istet
  Laud laud10 = new Laud(10, 8, new ArrayList<>()); // 8 istet
  ```

* Et luua reserveering, lõin funktsiooni lisaReserveering(), mis lihtsalt lisab kellaaja vastava laua massiivi:
   ```
    public void lisaReserveering(LocalDateTime reserveering) {
        reserveeringud.add(reserveering);
    }
    ```
* Lõin manuaalselt märtsi kuu kuupäevadega reserveeringud, et teha testmist kergemaks
  ```
  // Laud 1
    laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 1, 18, 0));
    laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 3, 19, 0));
    laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 5, 20, 0));
    laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 7, 17, 30));
    laud1.lisaReserveering(java.time.LocalDateTime.of(2026, 3, 9, 18, 30));
    ...
    jne teiste laudadega
  ```

* Kuid tegin ka juhusliku laudade broneerimise süsteemi, mis genereeritakse, kui frontend'is märgatakse, et valitud kuupäeval pole ühtegi olemasolevat broneeringut.

 ```
  @PostMapping("/api/reserveeringud/genereeri")
  public List<Laud> genereeriPäevaReserveeringud(@RequestParam String kuupaev) {
    LocalDate päev = LocalDate.parse(kuupaev);

    Random random = new Random();
    for (Laud laud : reserveeringud.getReserveeringud()) {
        // Iga laud saab 0-3 juhuslikku reserveeringut antud päeval
        int reserveeringuteArv = random.nextInt(4);
        for (int i = 0; i < reserveeringuteArv; i++) {
            int tund = 11 + random.nextInt(11); // Reserveeringud aegade vahemikus 11:00-21:00
            int minut = random.nextBoolean() ? 0 : 30;
            reserveeringud.lisaReserveering(laud.getLauaNr(), päev.atTime(tund, minut)
        );
        }
    }
    return reserveeringud.getReserveeringud();
}
  ```
  
2. Frontend koosneb ühest lehest, kus on võimalik valida külastajate arvu, kuupäeva, kellaaega ning restorani plaanilt laua, mida broneerida.
   Kui kasutaja soovib, on võimalik valida kolme filtri vahelt: "Akna lähedal", "Privaatne" ja "Mänguala lähedal", mis valides visuaalselt plaanil on eristatavad ülejäänud laudadest.
   Kui lauda pole võimalik broneerida, kuvatakse see punaselt ning kui kasutaja on meeldiva laua valinud, kuvatakse see heledama rohelise tooniga.

   Restorani põrandaplaani kuvamiseks otsisin lahendust, mis oleks visuaalselt atraktiivsem kui tavaline tabelivaade (mis oli ka minu eelmise CGI praktika lahenduses ning mida oleksin soovinud juba tollel ajal muuta). Uurides erinevaid võimalusi, leidsin, et SVG (Scalable Vector Graphics) sobib selleks ideaalselt. Uurisin selle kohta ning leidsin, et see võimaldab joonistada vektorgraafikat otse HTML-i sees. Avastasin, et SVG-d saab kasutada ka Vue rakenduses täpselt samamoodi nagu tavalises HTML-is, mistõttu sain kasutada :fill ja @click direktiive otse SVG elementidel, mis võimaldas laudade värve dünaamiliselt muuta ja klikke tuvastada.

# Murekohad

Suurimaks probleemiks selle projekti juures tuli suhtlus backend ja frontend vahel. Pidin uurima @PostMapping ja @GetMapping annotatsioonide kohta ning kasutama tehisintellekti abi, et mõned probleemid lahendada, mis esinesid andmete edastamisel frontend'ist backend'i. Eriti keeruliseks kujunes juhuslike reserveeringute genereerimine - kuna rakendus on üles ehitatud nii, et kõik broneeringud salvestatakse backendis, tuli tagada, et frontend ja backend suhtlevad õigesti ning andmed uuendatakse mõlemal poolel korrektselt.
   
