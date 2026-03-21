import { createApp } from 'vue'
import App from './App.vue'
import './main.css'
import PrimeVue from 'primevue/config'
import Aura from '@primeuix/themes/aura'
import ToastService from 'primevue/toastservice';

const app = createApp(App)
app.use(ToastService);
app.use(PrimeVue, {
    theme: {
        preset: Aura
    }
})
app.mount('#app')
