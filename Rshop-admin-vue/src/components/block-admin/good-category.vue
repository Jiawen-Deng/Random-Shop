<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();
// 定义全部数据的响应式变量
const allData = ref([]);
// 定义表格数据的响应式变量
const tableData = ref([]);
// 定义分页参数
const pageSize = ref(10);
const pageNum = ref(1);
const total = ref(0);

// 获取商品信息的函数
const fetchProducts = async () => {
  try {
    const response = await axios.post('http://localhost:8090/cat/list');
    allData.value = response.data; // 假设后端返回所有订单数据
    total.value = allData.value.length; // 总数据量
    paginate(allData.value); // 进行分页
    console.log("获得标签：", allData.value);
  } catch (error) {
    console.error('获取信息失败:', error);
  }
};

// 分页函数
const paginate = (data) => {
  const startIndex = (pageNum.value - 1) * pageSize.value;
  const endIndex = startIndex + pageSize.value;
  tableData.value = data.slice(startIndex, endIndex);
};

// 分页事件处理函数
const handleSizeChange = (val) => {
  pageSize.value = val;
  paginate(allData.value);
};

const handleCurrentChange = (val) => {
  pageNum.value = val;
  paginate(allData.value);
};

// 组件挂载时获取商品信息
onMounted(fetchProducts);

const viewDetails = (product) => {
  router.push({ name: 'AGoodData', params: { productId: product.gid } });
};

// 新增标签的方法
const addNewLabel = () => {
  router.push({ name: 'AddNewLabel', params: { } }); // 假设 'AddNewLabel' 是新增标签页面的路由名称
};
</script>

<template>
  <!-- 滚动条组件 -->
  <div>
    <div style="display: flex; justify-content: flex-start; align-items: flex-start; margin-top: 20px;">
      <!-- 新增标签按钮 -->
      <el-button type="primary" @click="addNewLabel">新增标签</el-button>
    </div>
    <el-scrollbar>
      <el-table :data="tableData" class="custom-table-row" style="width: 100%">
        <el-table-column prop="cid" label="CID"/>
        <el-table-column prop="cname" label="CNAME"/>
        <el-table-column prop="cparentid" label="CParentID"/>
      </el-table>
    </el-scrollbar>
    <el-pagination
      v-model:current-page="pageNum"
      v-model:page-size="pageSize"
      :page-sizes="[5, 10, 20]"
      :total="total"
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </div>
</template>

<style scoped>
/* 自定义表格行高 */
.custom-table-row .el-table .el-table__body {
  --el-table-row-height: 100px; /* 设置行高为100px，可以根据需要调整 */
}
</style>
