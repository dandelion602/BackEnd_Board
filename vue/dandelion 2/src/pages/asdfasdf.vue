<template>
  <q-page class="">
    <div class="row">
      <div v-for="item in itemList" :key="item.id" class="col-4 cardArea">
        <q-card class="myCard">


          <q-card-section>
            <div class="text-h6">{{item.title}}</div>
            <div class="text-subtitle2">by {{item.date}}</div>
          </q-card-section>

          <q-card-section class="q-pt-none">
            {{ item.contents }}
          </q-card-section>

        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script>
import axios from "axios";
export default {
  name: 'PageIndex',
  data: () => ({
    itemList: []
  }),
  mounted () {
    axios.post('http://localhost:9090/findBoardId/1',{
        headers: {
          'Access-Control-Allow-Origin': '*',
          'Content-Type': 'application/json; charset = utf-8'
        }
    })
    .then(res => {
      this.itemList = res;
      console.log(res)
    })
    .catch(err => {
        console.log(err);
    });
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