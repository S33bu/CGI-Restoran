<template>
  <div class="parent">
    <div class="div1 ">
       Broneeri laud
    </div>
    <div class="div2">
       <ul>
          <li v-for="laud in lauad" :key="laud.lauaNr">
            Laud {{ laud.lauaNr }}: {{ laud.kohtadeArv }} istet
          </li>
        </ul>
    </div>
</div>

</template>

<script setup>
  import "tailwindcss"
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

<style scoped>
.parent {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-template-rows: repeat(1, 1fr);
    gap: 8px;
}
</style>
