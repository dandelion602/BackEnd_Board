<template>
  <div class="q-pa-md">
    <div v-for="item in itemList" :key="item.number" class="q-col-gutter-md row items-start">

      <div class="col-4">

        <q-card class="my-card">
          <q-img
            :src="require('../assets/images/라이언1.png')"
            :ratio="1"

          />

          <q-card-section>
            <div class="text-h6">{{ item.title }}</div>
            <div class="text-subtitle2">{{ item.price }}</div>
          </q-card-section>

          <q-card-section class="q-pt-none">
            {{ item.contents }}
          </q-card-section>
        </q-card>



      </div>
    </div>
  </div>
</template>



<script>
import axios from "axios";
export default {
  name: 'PageIndex',
  data() {
    return {
      itemList: []
    }
  },
  mounted() {
    this.mainItem()
  },
  methods : {
    onDetail (itemId) {
      this.$router.push(`/detail/${itemId}`)
    },
    numberWithCommas(num) {
      return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    mainItem() {
      axios
        .get('http://localhost:9090/')
        .then(res => {
          this.itemList = res.data;
          console.log(this.itemList);
        })
        .catch(err => {
          console.log(err);
        })
    }
  }
}
</script>

<style lang="scss" scoped>
.cardArea {
  padding: 30px;
  .myCard {
    cursor: pointer;
    transition: all .2s ease-in-out;
    &:hover {
      transform: scale(1.03);
    }
  }
}
</style>

