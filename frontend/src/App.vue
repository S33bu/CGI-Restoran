<template>
  <ul>
  <li v-for="laud in lauad" :key="laud.lauaNr">
    Laud {{ laud.lauaNr }}: {{ laud.kohtadeArv }} istet
  </li>
</ul>
</template>

<script setup>
  import { ref, onMounted } from 'vue';

  const lauad = ref([]);
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
</script>

<style scoped></style>
