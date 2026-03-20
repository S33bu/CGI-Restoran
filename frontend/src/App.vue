<template>
  <div class="parent">
    <div class="div1"> Broneeri laud
      <div>Mitu inimest? (max 10)
        <InputNumber v-model="inimesteArv" showButtons buttonLayout="vertical" inputId="minmax" :min="1" :max="10" style="width: 3rem;" />
      </div>
       <div>
          Valige kuupäev ja kellaaeg:
          <DatePicker v-model="valitudKuupäev" showIcon iconDisplay="input" />
          <DatePicker v-model="valitudKell" showIcon iconDisplay="input" timeOnly/>
       </div>
       <div>Soovitatud lauad: {{ vabadLauad }}</div>
    </div>
    
    <div class="div2">
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

  const date = ref(null)
  const lauad = ref([]);
  const inimesteArv = ref(1);
  const valitudKuupäev = ref(null);
  const valitudKell = ref(null);

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

 const vabadLauad = computed(() => {
  if (!valitudKuupäev.value || !valitudKell.value) {
    return "Palun valige kuupäev ja kellaaeg.";
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
             reserveeringAeg.getTime() > soovitudAeg.getTime() + 2 * 60 * 60 * 1000;
    });
  });

  return vabad.length > 0 ? vabad.map(laud => laud.lauaNr).join(", ") : "Puuduvad vabad lauad.";
});

</script>

<style scoped>
.parent {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-template-rows: repeat(1, 1fr);
    gap: 8px;
}
</style>
