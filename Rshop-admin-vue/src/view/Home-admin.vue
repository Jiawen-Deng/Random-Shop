<template>
  <!-- 根容器 -->
  <el-container class="layout-container-demo" style="height: 100%;display: flex;flex-direction: column;">
    <div style="height: 100%;display: flex;">
      <ShopLogo></ShopLogo>
      <el-header style="width: 82%;text-align: right; font-size: 12px; display: flex; align-items: center; height: 80px; background-color: var(--el-color-primary-light-9);">
        <admin-head></admin-head>
      </el-header>
    </div>
    <!-- 侧边栏 -->
    <div style="height: 100%;display: flex;">
      <el-aside width="300px" height="100%">
        <admin-menu @menu-click="handleMenuClick" style="height: 100%"></admin-menu>
      </el-aside>
      <!-- 主区域 -->
      <el-container>
        <!-- 主要内容区域 -->
        <el-main style="height: 100%">
          <div style="height: 400px;display: contents">
            <component :is="currentComponent" :account="account"></component>
          </div>
        </el-main>
      </el-container>
    </div>
  </el-container>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import AdminMenu from "@/components/block-admin/adminMenu.vue";
import AdminHead from "@/components/block-admin/adminHead.vue";
import AdminMainUser from "@/components/block-admin/adminMain-user.vue";
import ShopLogo from "@/components/Shop-Logo.vue";
import AdminOrder from "@/components/block-admin/admin-order.vue";
import AdminPwd from "@/components/block-admin/admin-pwd.vue";
import AdminInventory from "@/components/block-admin/admin-Inventory.vue";
import AdminNewPro from "@/components/block-admin/admin-NewPro.vue";
import ShellHistory from "@/components/block-admin/shell-history.vue";
import ShellIng from "@/components/block-admin/shell-ing.vue";
import ShellNever from "@/components/block-admin/shell-never.vue";
import AdminProduct from "@/components/block-admin/admin-product.vue";
import AdminDetail from "@/components/block-admin/admin-detail.vue";
import AdminUpdate from "@/components/block-admin/admin-update.vue";
import AdminCategory from "@/components/block-admin/good-category.vue"
// 定义一个响应式变量来存储当前显示的组件
const currentComponent = ref(AdminMainUser);
import {useRoute} from "vue-router";
const route = useRoute(); // 使用useRoute钩子
const account = ref(route.query.account); // 读取account参数
const handleMenuClick = (index) => {
  switch (index) {
    case '1':
      currentComponent.value = AdminMainUser;
      break;
    case '2':
      currentComponent.value = ShellIng;
      break;
    case '3':
      currentComponent.value = ShellNever;
      break;
    case '4':
      currentComponent.value = ShellIng;
      break;
    case '5':
      currentComponent.value = ShellHistory;
      break;
    case '6':
      currentComponent.value = AdminProduct;
      break;
    case '7':
      currentComponent.value = AdminOrder;
      break;
    case '8':
      currentComponent.value = AdminCategory;
      break;
    case '9':
      currentComponent.value = AdminPwd;
      break;
  }
};
</script>

<style scoped>
/* 样式定义 */
.layout-container-demo {
  padding: 0;
  color: var(--el-text-color-primary);
}

.layout-container-demo .el-aside {
  padding: 0;
  color: var(--el-text-color-primary);
  background: var(--el-color-primary-light-8);
}
.layout-container-demo .el-menu {
  padding: 0;
  border-right: none;
}
.layout-container-demo .el-main {
  padding: 0;
}
.layout-container-demo .toolbar {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  height: 100%;
}
html, body, #app {
  height: 100%;
  margin: 0;
}

.logo img {
  max-width: 100%; /* Ensure the logo scales with the container */
  height: 100%; /* Ensures logo height matches container */
}
</style>
