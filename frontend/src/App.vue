<template>
  <div class="parent" >
    <div class="div1"> Broneeri laud
      <div>Mitu inimest? (max 8)
        <InputNumber v-model="inimesteArv" showButtons buttonLayout="vertical" inputId="minmax" :min="1" :max="8" style="width: 3rem;" />
      </div>
       <div>
          Valige kuupäev ja kellaaeg:
          <DatePicker v-model="valitudKuupäev" showIcon iconDisplay="input" />
          <DatePicker v-model="valitudKell" showIcon iconDisplay="input" timeOnly/>
       </div>
       <div>Soovitatud lauad: {{ filteredLauad }}</div>
       <div>Eelistused (valikulised):
    <div style="display: flex; gap: 0.5rem; margin-top: 0.5rem;">
        <Button 
            @click="filterValitud = filterValitud === 'Akna lähedal' ? null : 'Akna lähedal'"
            :outlined="filterValitud !== 'Akna lähedal'"
            raised
        >Akna lähedal</Button>
        <Button 
            @click="filterValitud = filterValitud === 'Privaatne' ? null : 'Privaatne'"
            :outlined="filterValitud !== 'Privaatne'"
            raised
        >Privaatne</Button>
    </div>
</div>
       <Button @click="teeReserveering(valitudLaud, valitudKuupäev, valitudKell)" :disabled="!valitudLaud" raised>Broneeri Laud</Button>
    </div>
    

    <!-- RUUMI SVG GENEREERITUD AI ABIL (funktsioonid, värvide vahetamine / soovitused käsitsi lisatud) -->
    <!-- Asetuse muudatused samuti käsitsi tehtud -->
    <div class="div2">
    <svg width="75%" viewBox="0 0 680 820">
      <defs>
        <marker id="arrow" viewBox="0 0 10 10" refX="8" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
          <path d="M2 1L8 5L2 9" fill="none" stroke="context-stroke" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
        </marker>
      </defs>
 
      <!-- Ruumi outline -->
      <rect x="30" y="60" width="620" height="730" rx="6" fill="#fafaf9" stroke="#aaa" stroke-width="2.5"/>
 
      <!-- Aknad üleval -->
      <rect x="30" y="60" width="620" height="8" fill="#888" opacity="0.25" rx="3"/>
      <rect x="80"  y="56" width="90" height="10" rx="2" fill="#dbeafe" stroke="#3B8BD4" stroke-width="1"/>
      <rect x="220" y="56" width="90" height="10" rx="2" fill="#dbeafe" stroke="#3B8BD4" stroke-width="1"/>
      <rect x="360" y="56" width="90" height="10" rx="2" fill="#dbeafe" stroke="#3B8BD4" stroke-width="1"/>
      <rect x="500" y="56" width="90" height="10" rx="2" fill="#dbeafe" stroke="#3B8BD4" stroke-width="1"/>
      <text font-family="sans-serif" font-size="12" x="340" y="54" text-anchor="middle" fill="#185FA5">Aknad</text>
 
      <!-- Uks all -->
      <rect x="295" y="782" width="90" height="8" rx="2" fill="#fff" stroke="#ccc" stroke-width="1"/>
      <text font-family="sans-serif" font-size="12" x="340" y="805" text-anchor="middle" fill="#666">Sissepääs</text>
 
      <!-- ===== 2-SEAT TABLES ===== -->

      <!-- T1:  -->
      <g @click="vajutaLauale(1)" style="cursor: pointer;">
        <rect x="100" y="78" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#888" stroke-width="0.8"/>
        <rect x="75" y="90" width="80" height="55" rx="8" :fill="lauaVärv(1)" :stroke="soovitatudLaud(1)" stroke-width="1.5"/>
        <text font-family="sans-serif" font-size="14" font-weight="500" x="115" y="120" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T1</text>
        <text font-family="sans-serif" font-size="12" x="115" y="134" text-anchor="middle" fill="#666">2 kohta</text>
        <!-- bottom chairs -->
        <rect x="100"  y="144" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#888" stroke-width="0.8"/>
        <!-- window badge -->
        <rect x="77" y="159" width="76" height="14" rx="4" fill="#dbeafe" stroke="#3B8BD4" stroke-width="0.8"/>
        <text font-family="sans-serif" font-size="11" x="115" y="169" text-anchor="middle" fill="#185FA5">akna lähedal</text>
      </g>


      <!-- T2:  -->
       <g @click="vajutaLauale(2)" style="cursor: pointer;"> 
      <rect x="242" y="78" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#888" stroke-width="0.8"/>
      <rect x="215" y="90" width="80" height="55" rx="8" :fill="lauaVärv(2)" :stroke="soovitatudLaud(2)" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="14" font-weight="500" x="255" y="120" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T2</text>
      <text font-family="sans-serif" font-size="12" x="255" y="134" text-anchor="middle" fill="#666">2 kohta</text>
      <rect x="242" y="144" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#888" stroke-width="0.8"/>
      <rect x="217" y="159" width="76" height="14" rx="4" fill="#dbeafe" stroke="#3B8BD4" stroke-width="0.8"/>
      <text font-family="sans-serif" font-size="11" x="255" y="169" text-anchor="middle" fill="#185FA5">akna lähedal</text>
        </g>


      <!-- T3: -->
      <g @click="vajutaLauale(3)" style="cursor: pointer;"> 
        <rect x="382" y="78" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#888" stroke-width="0.8"/>
        <rect x="355" y="90" width="80" height="55" rx="8" :fill="lauaVärv(3)" :stroke="soovitatudLaud(3)" stroke-width="1.5"/>
        <text font-family="sans-serif" font-size="14" font-weight="500" x="395" y="120" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T3</text>
        <text font-family="sans-serif" font-size="12" x="395" y="134" text-anchor="middle" fill="#666">2 kohta</text>
        <rect x="382" y="144" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#888" stroke-width="0.8"/>
        <!-- window badge -->
        <rect x="357" y="159" width="76" height="14" rx="4" fill="#dbeafe" stroke="#3B8BD4" stroke-width="0.8"/>
        <text font-family="sans-serif" font-size="11" x="395" y="169" text-anchor="middle" fill="#185FA5">akna lähedal</text>
      </g>


      <!-- ===== 4-SEAT TABLES ===== -->
      <g @click="vajutaLauale(4)" style="cursor: pointer;"> 
      <rect x="73"  y="230" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="109" y="230" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="60" y="242" width="90" height="70" rx="8" :fill="lauaVärv(4)" :stroke="soovitatudLaud(4)" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="14" font-weight="500" x="105" y="274" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T4</text>
      <text font-family="sans-serif" font-size="12" x="105" y="288" text-anchor="middle" fill="#666">4 kohta</text>
      <rect x="73"  y="311" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="109" y="311" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      </g>


      <!-- T5: -->
      <g @click="vajutaLauale(5)" style="cursor: pointer;"> 
      <rect x="228" y="230" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="264" y="230" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="215" y="242" width="90" height="70" rx="8" :fill="lauaVärv(5)" :stroke="soovitatudLaud(5)" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="14" font-weight="500" x="260" y="274" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T5</text>
      <text font-family="sans-serif" font-size="12" x="260" y="288" text-anchor="middle" fill="#666">4 kohta</text>
      <rect x="228" y="311" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="264" y="311" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      </g>

      <!-- T6: -->
      <g @click="vajutaLauale(6)" style="cursor: pointer;"> 
      <rect x="408" y="230" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="444" y="230" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="395" y="242" width="90" height="70" rx="8" :fill="lauaVärv(6)" :stroke="soovitatudLaud(6)" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="14" font-weight="500" x="440" y="274" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T6</text>
      <text font-family="sans-serif" font-size="12" x="440" y="288" text-anchor="middle" fill="#666">4 kohta</text>
      <rect x="408" y="311" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="444" y="311" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      </g>


      <!-- ===== 6-SEAT TABLES ===== -->
      <!-- T7: -->
      <g @click="vajutaLauale(7)" style="cursor: pointer;"> 
      <rect x="70"  y="408" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="106" y="408" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="142" y="408" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="55" y="420" width="130" height="75" rx="8" :fill="lauaVärv(7)" :stroke="soovitatudLaud(7)" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="14" font-weight="500" x="120" y="454" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T7</text>
      <text font-family="sans-serif" font-size="12" x="120" y="468" text-anchor="middle" fill="#666">6 kohta</text>
      <rect x="70"  y="494" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="106" y="494" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="142" y="494" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      </g>


      <!-- T8: -->
       <g @click="vajutaLauale(8)" style="cursor: pointer;"> 
      <rect x="260" y="408" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="296" y="408" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="332" y="408" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="245" y="420" width="130" height="75" rx="8" :fill="lauaVärv(8)" :stroke="soovitatudLaud(8)" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="14" font-weight="500" x="310" y="454" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T8</text>
      <text font-family="sans-serif" font-size="12" x="310" y="468" text-anchor="middle" fill="#666">6 kohta</text>
      <rect x="260" y="494" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="296" y="494" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="332" y="494" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
        </g>


      <!-- T9:  -->
       <g @click="vajutaLauale(9)" style="cursor: pointer;"> 
      <rect x="465" y="588" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="501" y="588" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="537" y="588" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="450" y="600" width="130" height="75" rx="8" :fill="lauaVärv(9)" :stroke="soovitatudLaud(9)" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="14" font-weight="500" x="515" y="634" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T9</text>
      <text font-family="sans-serif" font-size="12" x="515" y="648" text-anchor="middle" fill="#666">6 kohta</text>
      <rect x="465" y="674" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="501" y="674" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="537" y="674" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
        </g>

      <!-- ===== 8-SEAT TABLE ===== -->
       <g @click="vajutaLauale(10)" style="cursor: pointer;"> 
      <rect x="77"  y="600" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="113" y="600" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="149" y="600" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="185" y="600" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="55" y="612" width="180" height="80" rx="8" :fill="lauaVärv(10)" :stroke="soovitatudLaud(10)" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="14" font-weight="500" x="145" y="648" text-anchor="middle" dominant-baseline="central" fill="#1a1a1a">T10</text>
      <text font-family="sans-serif" font-size="12" x="145" y="662" text-anchor="middle" fill="#666">8 kohta</text>
      <rect x="77"  y="691" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="113" y="691" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="149" y="691" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      <rect x="185" y="691" width="28" height="12" rx="4" fill="#f5f5f4" stroke="#aaa" stroke-width="0.8"/>
      </g>

      <!-- ===== LEGEND ===== -->
      <rect x="400" y="710" width="230" height="70" rx="8" fill="#f5f5f4" stroke="#ccc" stroke-width="0.8"/>
      <text font-family="sans-serif" font-size="14" font-weight="500" x="515" y="727" text-anchor="middle" fill="#1a1a1a">Legend</text>
      <rect x="416" y="736" width="26" height="14" rx="4" fill="#f5f5f4" stroke="#3B8BD4" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="11" x="450" y="746" fill="#666">Soovitatud laud</text>
      <rect x="416" y="756" width="26" height="14" rx="4" fill="#ff9b9b" stroke="#aaa" stroke-width="1.5"/>
      <text font-family="sans-serif" font-size="11" x="450" y="766" fill="#666">Hõivatud / Mittesobilik laud</text>
    </svg>
 
           <ul>
          <li v-for="laud in lauad" :key="laud.lauaNr">
            Laud {{ laud.lauaNr }}: {{ laud.kohtadeArv }} istet, {{ laud.reserveeringud.length }} reserveeringut
          </li>
        </ul>

      </div>
  </div>

</template>

<script setup>
  import { ref, onMounted, computed } from 'vue';
  import DatePicker from 'primevue/datepicker'
  import InputNumber from 'primevue/inputnumber';
  import Button from 'primevue/button';

  const date = ref(null)
  const lauad = ref([]);
  const inimesteArv = ref(1);
  const valitudKuupäev = ref(null);
  const valitudKell = ref(null);

  const valitudLaud = ref(null);
  const filterValitud = ref(null);
  

  const minDate = new Date(); //tänane kuupäev
  onMounted(() => {
    fetch("/api/reserveeringud")
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      lauad.value = data;
    }).catch((error) => {
      console.error("Error fetching data:", error);
    });
  })


  function lauaVärv(lauaNr) {
    if (!valitudKuupäev.value || !valitudKell.value) {
      return "#f5f5f4"; //hall, kui kuupäev või kellaaeg pole valitud
    }

    if (!vabadLauad.value.includes(lauaNr)) {
      return "#ff9b9b" ; //punane, kui laud on hõivatud
    } else if (valitudLaud.value === lauaNr) {
      return "#B8E3BB"; //roheline, kui laud on valitud
    } else {
      return "#f5f5f4"; //hall, kui laud on vaba, aga mitte valitud
      
    }
    
  }

  function vajutaLauale(lauaNr) {
    if (!vabadLauad.value.includes(lauaNr) || valitudLaud.value === lauaNr ) {
      valitudLaud.value = null;
    } else {
      valitudLaud.value = lauaNr; 
    }
  }

  function soovitatudLaud(lauaNr) {
    // teeme kindlaks, et visuaalselt ei soovitaks lauda, mis pole vaba, isegi kui see vastab eelistustele
    const onVaba = vabadLauad.value.includes(lauaNr);

    if (filterValitud.value == "Akna lähedal" && (lauaNr === 1 || lauaNr === 2 || lauaNr === 3) && onVaba) {
      return "#3B8BD4"; //sinine, kui laud on akna lähedal
    } else if (filterValitud.value == "Privaatne" && (lauaNr === 9 || lauaNr === 10) && onVaba) {
      return "#534AB7"; //lilla, kui laud on 8-kohaline
    } else {
      return "#aaa"; //tavaline hall, kui laud ei vasta eelistustele
    }
  }

  function teeReserveering(lauaNr, kuupäev, kell){
    const reserveering = new Date(kuupäev);
    reserveering.setHours(kell.getHours());
    reserveering.setMinutes(kell.getMinutes());
    
    const kohalikAeg = new Date(reserveering.getTime() - reserveering.getTimezoneOffset() * 60000).toISOString().slice(0, 16);

    fetch("/api/reserveeringud", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        laud: Number(lauaNr),
        reserveering: kohalikAeg,
      }),
    }).then((response) => { if (!response.ok) {
        throw new Error("Response was not ok");
    }  return response.json();
    }).then((data) => {
      lauad.value = data; // uuendame lauad uue info põhjal
      valitudLaud.value = null; // tühjendame valiku pärast reserveeringu tegemist
    })
  }

 const vabadLauad = computed(() => { 
  if (!valitudKuupäev.value || !valitudKell.value) {
    return [];
  }
  const soovitudAeg = new Date(valitudKuupäev.value);
  soovitudAeg.setHours(valitudKell.value.getHours());
  soovitudAeg.setMinutes(valitudKell.value.getMinutes());

  const vabad = lauad.value.filter(laud => {
    if (laud.kohtadeArv < inimesteArv.value) {
      return false; // ei sobi, kui laual puudub piisav arv kohti
    }
    return laud.reserveeringud.every(reserveering => {
      const reserveeringAeg = new Date(reserveering);
      return reserveeringAeg.getTime() < soovitudAeg.getTime() - 2 * 60 * 60 * 1000 || 
             reserveeringAeg.getTime() >= soovitudAeg.getTime() + 2 * 60 * 60 * 1000;
    });
  });

  return vabad.length > 0 ? vabad.map(laud => Number(laud.lauaNr)) : [];
});

const filteredLauad = computed(() => {
  if (filterValitud.value === "Akna lähedal") {
    return vabadLauad.value.filter(laud => laud === 1 || laud === 2 || laud === 3);
  } else if (filterValitud.value === "Privaatne") {
    return vabadLauad.value.filter(laud => laud === 9 || laud === 10);
  } else {
    return vabadLauad.value;
  }
});

</script>

<style scoped>
.parent {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-template-rows: repeat(1, 1fr);
    gap: 8px;
}
      text { font-family: sans-serif; }
      .th { font-size: 14px; font-weight: 500; fill: #1a1a1a; }
      .ts { font-size: 12px; font-weight: 400; fill: #666; }

</style>
