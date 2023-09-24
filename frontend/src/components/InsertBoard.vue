<template>
  <div>
    <h1>게시판 등록</h1>
    <div class="AddWrap">
      <form>
        <table class="tbAdd">
          <colgroup>
            <col width="15%" />
            <col width="*" />
          </colgroup>
          <tr>
            <th>번호</th>
            <td><input type="number" id="non" v-model="non"/></td>
          </tr>
          <tr>
            <th>구분</th>
            <td><input type="number" id="subNo" v-model="subNo" /></td>
          </tr>
          <tr>
            <th>SEQ</th>
            <td><input type="number" id="seq" v-model="seq" /></td>
          </tr>
          <tr>
            <th>제목</th>
            <td><textarea v-model="title" ref="title"></textarea></td>
          </tr>
        </table>
      </form>
    </div>

    <div class="btnWrap">
      <a @click="fnList" class="btn">목록</a>
      <a @click="saveBt" class="btnAdd btn">저장</a>
    </div>
  </div>
</template>

<script>
export default {
  data() { //변수 생성
    return{
      non:'',
      subNo:'',
      seq:'',
      title:'',
      form:''

    }
  }
  ,methods:{
    fnList(){ //리스트 화면으로 이동 함수
      this.$router.push({path:'./list',query:this.body});
    },

    saveBt() { //등록 프로세스
      if(!this.non) {
        alert("번호를 입력해 주세요");
        this.$refs.non.focus(); //방식으로 선택자를 찾는다.
        return;
      }

      if(!this.subNo) {
        alert("구분을 입력해 주세요");
        this.$refs.subNo.focus();
        return;
      }

      if(!this.seq) {
        alert("SEQ를 입력해 주세요");
        this.$refs.seq.focus();
        return;
      }

      this.form = {
        non:this.non
       ,subNo: this.subNo
       ,seq: this.seq
       ,title: this.title
      }

      this.$axios.post('http://localhost:8081/save', this.form)
          .then((res)=>{
            if(res.data.success) {
              alert('등록되었습니다.');
              this.fnList();
            } else {
              alert("실패했습니다.");
            }
          })
          .catch((err)=>{
            console.log(err);
          })

/*      this.$axios({
        url: '/http://localhost:8081/save',
        method: 'post',
        data: {
          non: 'non'
        }
      })
          .then(function a(response) {
            console.log(response)
          })
          .catch(function (error) {
            console.log(error);
          })*/
    },
  }
}
</script>

<style scoped>
.tbAdd{border-top:1px solid #888;}
.tbAdd th, .tbAdd td{border-bottom:1px solid #eee; padding:5px 0;}
.tbAdd td{padding:10px 10px; box-sizing:border-box;}
.tbAdd td input{width:100%; min-height:30px; box-sizing:border-box; padding:0 10px;}
.tbAdd td textarea{width:100%; min-height:300px; padding:10px; box-sizing:border-box;}
.btnWrap{text-align:center; margin:20px 0 0 0;}
.btnWrap a{margin:0 10px;}
</style>